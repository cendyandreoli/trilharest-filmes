package com.opensanca.trilharest.filmes.filmes;

import java.time.Duration;
import java.time.LocalDate;
import java.util.UUID;

public class Filme {
    private UUID id;
    private String nome;
    private Duration duracao;
    private LocalDate inicioExibicao;
    private LocalDate fimExibicao; //Localdate ignora o fuso horario amém?
    private String sinopse;


//    public Filme(UUID id, String nome, Duration duracao, LocalDate inicioExibicao, LocalDate of, LocalDate localDate){
//
//    }
    public boolean emExibicao(LocalDate referencia){
        if(getInicioExibicao() == null || getFimExibicao() == null){
            return false;
        }else{
            LocalDate inicio = getInicioExibicao();
            LocalDate fim = getFimExibicao();
            boolean hojeDepoisDoInicio = inicio.equals(referencia) || inicio.isBefore(referencia);
            boolean hojeDepoisDoFim = fim.equals(referencia) || fim.isAfter(referencia);
            return hojeDepoisDoInicio && hojeDepoisDoFim;
        }
    }

//    public Filme(UUID id, String nome, String s, Duration duration, LocalDate of, LocalDate of1) {
//    }

    public Filme(UUID id, String nome, String sinopse, Duration duracao, LocalDate inicioExibicao, LocalDate fimExibicao) {
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
        this.inicioExibicao = inicioExibicao;
        this.fimExibicao = fimExibicao;
        this.sinopse = sinopse;
    }

        public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    public LocalDate getInicioExibicao() {
        return inicioExibicao;
    }

    public void setInicioExibicao(LocalDate inicioExibicao) {
        this.inicioExibicao = inicioExibicao;
    }

    public LocalDate getFimExibicao() {
        return fimExibicao;
    }

    public void setFimExibicao(LocalDate fimExibicao) {
        this.fimExibicao = fimExibicao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }


}
