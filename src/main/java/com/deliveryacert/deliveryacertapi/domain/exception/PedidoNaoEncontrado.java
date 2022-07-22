package com.deliveryacert.deliveryacertapi.domain.exception;

public class PedidoNaoEncontrado extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PedidoNaoEncontrado(String mensagem) {
        super(mensagem);
    }

    public PedidoNaoEncontrado(Long pedidoId) {
        this(String.format("Pedido %d não encontrado.", pedidoId));
    }

}
