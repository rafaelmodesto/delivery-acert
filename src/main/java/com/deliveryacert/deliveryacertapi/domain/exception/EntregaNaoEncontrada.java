package com.deliveryacert.deliveryacertapi.domain.exception;

public class EntregaNaoEncontrada extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EntregaNaoEncontrada(String mensagem) {
        super(mensagem);
    }

    public EntregaNaoEncontrada(Long entregaId) {
        this(String.format("Entrega %d não encontrada.", entregaId));
    }

}
