package com.opensanca.trilharest.filmes.filmes;
import com.opensanca.trilharest.filmes.comun.Pagina;
import com.opensanca.trilharest.filmes.comun.ParametrosDePaginacao;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class RepositoryRAM implements FilmesRepository {

    private static List<Filme> registros = Arrays.asList(
            new Filme(UUID.randomUUID(), "Filme 1", "Sinopse do filme 1",
                Duration.ofMinutes(153),
                LocalDate.of(2017, 10, 1),
                LocalDate.of(2017, 10, 23)),
            new Filme(UUID.randomUUID(), "Filme 2", (String) null,
                    null,
                    LocalDate.of(2017, 10, 2),
                    LocalDate.of(2017, 10, 19)),
            new Filme(UUID.randomUUID(), "Filme 3", (String) null,
                    null, null, null),
            new Filme(UUID.randomUUID(), "Filme 4", "Sinopse do filme 4",
                Duration.ofHours(1),
                LocalDate.of(2016, 10, 2),
                LocalDate.of(2016, 10, 22))
    );

    @Override
    public Pagina<Filme> buscarPaginaEmExibicao(ParametrosDePaginacao parametrosDePaginacao, LocalDate referencia) {
        List<Filme> emExibicao = registros.stream()
                .filter(filme -> filme.emExibicao(referencia))
                .collect(Collectors.toList());

        Integer pagina = parametrosDePaginacao.getPagina();
        Integer tamanhoDaPagina = parametrosDePaginacao.getTamanhoDaPagina();
        Integer primeiroRegistro = (pagina - 1) * tamanhoDaPagina;
        Integer ultimoRegistro = primeiroRegistro + tamanhoDaPagina;
        Integer totalDeRegistros = emExibicao.size();
        List<Filme> registros = emExibicao.subList(primeiroRegistro,
                Math.min(totalDeRegistros, ultimoRegistro));

        Pagina<Filme> paginaDeRegistros = new Pagina<>();
        paginaDeRegistros.setRegistros(registros);
        paginaDeRegistros.setTotalDeRegistros(totalDeRegistros);
        return paginaDeRegistros;
    }

    @Override
    public Filme buscarPorId(UUID id) {
//        for(int i =0; i<registros.size(); i++){
//            if(registros.get(i).getId().equals(id)){
//                return registros.get(i);
//            }
//        }
        return registros.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Não encontrei nadinha"));
    }
}
