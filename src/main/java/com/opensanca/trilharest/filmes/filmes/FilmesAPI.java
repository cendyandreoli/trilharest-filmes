package com.opensanca.trilharest.filmes.filmes;

import com.opensanca.trilharest.filmes.comun.Pagina;
import com.opensanca.trilharest.filmes.comun.ParametrosDePaginacao;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/filmes")
public class FilmesAPI {

    @Autowired
    private FilmesRepository filmesRepository;

    @RequestMapping(path = "/em-exibicao", method = RequestMethod.GET)
    public Pagina<Filme> getEmExibicao(
            ParametrosDePaginacao parametrosDePaginacao) {
        if(parametrosDePaginacao == null){
            parametrosDePaginacao = new ParametrosDePaginacao();
        }
        LocalDate hoje = LocalDate.now();
        return filmesRepository.buscarPaginaEmExibicao(parametrosDePaginacao, hoje);
    }

    @GetMapping("/{id}")
    public Filme getPortId(@PathVariable UUID id){
        return this.filmesRepository.buscarPorId(id);
    }

}
