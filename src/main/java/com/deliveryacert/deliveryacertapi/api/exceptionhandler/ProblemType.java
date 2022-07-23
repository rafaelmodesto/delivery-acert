package com.deliveryacert.deliveryacertapi.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado");

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "https://deliveryacert.com" + path;
        this.title = title;
    }
}
