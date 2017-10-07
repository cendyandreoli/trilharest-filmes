package com.opensanca.trilharest.filmes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration //abilita configuração default do spring
@ComponentScan //busca em todos os pacotes e subpacotes por anotações
public class FilmsApplication {

    public static void main(String[] args){

        SpringApplication.run(FilmsApplication.class, args);

    }

}
