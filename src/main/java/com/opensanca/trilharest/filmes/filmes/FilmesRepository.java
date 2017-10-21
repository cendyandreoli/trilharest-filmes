package com.opensanca.trilharest.filmes.filmes;

import com.opensanca.trilharest.filmes.comun.Pagina;
import com.opensanca.trilharest.filmes.comun.ParametrosDePaginacao;

import java.time.LocalDate;
import java.util.UUID;

public interface FilmesRepository {

    Pagina<Filme> buscarPaginaEmExibicao(ParametrosDePaginacao parametrosDePaginacao, LocalDate referencia);


    Filme buscarPorId(UUID id   );

}
