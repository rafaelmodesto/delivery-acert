package com.deliveryacert.deliveryacertapi.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public abstract class RequisicaoInvalida extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RequisicaoInvalida(String mensagem) {
        super(mensagem);
    }


}
