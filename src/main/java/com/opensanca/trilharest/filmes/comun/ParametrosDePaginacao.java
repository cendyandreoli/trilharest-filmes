package com.opensanca.trilharest.filmes.comun;

public class ParametrosDePaginacao {
    private Integer pagina = 1; //0 - base
    private Integer tamanhoDaPagina = 3;

    public Integer getPagina() {
        return pagina;
    }

    public void setPagina(Integer pagina) {
        this.pagina = pagina;
    }

    public Integer getTamanhoDaPagina() {
        return tamanhoDaPagina;
    }

    public void setTamanhoDaPagina(Integer tamanhoDaPagina) {
        this.tamanhoDaPagina = tamanhoDaPagina;
    }
}
