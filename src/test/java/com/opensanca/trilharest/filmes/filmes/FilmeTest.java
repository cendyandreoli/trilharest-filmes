package com.opensanca.trilharest.filmes.filmes;

import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.util.UUID;

public class FilmeTest {
    @Test
    public void foraDeExibicaoSeDatasNulas(){
        //Preparação
        Filme filme = new Filme(null, null, null, null, null, null);
        LocalDate referencia = LocalDate.of(2017,10,21);
        //Processando
        Boolean resultado = filme.emExibicao(referencia);
        //Verificacao
        Assert.assertFalse(resultado);
    }
    @Test
    public void emExibicaoSeDentroDeInterValoDeDatas(){
        //Preparação
        Filme filme = new Filme(null, null, null, null, LocalDate.of(2017,10,1),  LocalDate.of(2017,10,30));
        LocalDate referencia = LocalDate.of(2017,10,21);
        //Processando
        Boolean resultado = filme.emExibicao(referencia);
        //Verificacao
        Assert.assertTrue(resultado);
    }
    @Test
    public void foradeExibicaoSeForaDoIntervaloDeDatas(){
        //Preparação
        Filme filme = new Filme(null, null, null, null, LocalDate.of(2016,10,1),  LocalDate.of(2016,10,30));
        LocalDate referencia = LocalDate.of(2017,10,21);
        //Processando
        Boolean resultado = filme.emExibicao(referencia);
        //Verificacao
        Assert.assertFalse(resultado);
    }
    @Test
    public void foradeExibicaoSeInicioExibicaoNulo(){
        //Preparação
        Filme filme = new Filme(null, null, null, null, null,  LocalDate.of(2016,10,30));
        LocalDate referencia = LocalDate.of(2017,10,21);
        //Processando
        Boolean resultado = filme.emExibicao(referencia);
        //Verificacao
        Assert.assertFalse(resultado);
    }
    @Test
    public void foradeExibicaoSeFimExibicaoNulo(){
        //Preparação
        Filme filme = new Filme(null, null, null, null, LocalDate.of(2016,10,1),  null);
        LocalDate referencia = LocalDate.of(2017,10,21);
        //Processando
        Boolean resultado = filme.emExibicao(referencia);
        //Verificacao
        Assert.assertFalse(resultado);
    }
    @Test
    public void emExibicaoSeInicioExatamenteHoje(){
        //Preparação
        Filme filme = new Filme(null, null, null, null, LocalDate.of(2017,10,21),  LocalDate.of(2017,10,22));
        LocalDate referencia = LocalDate.of(2017,10,21);
        //Processando
        Boolean resultado = filme.emExibicao(referencia);
        //Verificacao
        Assert.assertTrue(resultado);
    }
    @Test
    public void emExibicaoSeFimExatamenteHoje(){
        //Preparação
        Filme filme = new Filme(null, null, null, null, LocalDate.of(2017,10,20),  LocalDate.of(2017,10,21));
        LocalDate referencia = LocalDate.of(2017,10,21);
        //Processando
        Boolean resultado = filme.emExibicao(referencia);
        //Verificacao
        Assert.assertTrue(resultado);
    }

}
