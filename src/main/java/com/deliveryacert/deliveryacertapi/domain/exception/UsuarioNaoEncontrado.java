package com.deliveryacert.deliveryacertapi.domain.exception;

public class UsuarioNaoEncontrado extends RecursoNaoEncontrado {

    private static final long serialVersionUID = 1L;

    public UsuarioNaoEncontrado(String mensagem) {
        super(mensagem);
    }

    public UsuarioNaoEncontrado(Long usuarioId) {
        this(String.format("Usuário %d não existe.", usuarioId));
    }

}
