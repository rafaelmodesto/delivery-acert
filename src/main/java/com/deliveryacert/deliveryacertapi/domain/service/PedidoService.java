package com.deliveryacert.deliveryacertapi.domain.service;

import com.deliveryacert.deliveryacertapi.domain.exception.PedidoNaoEncontrado;
import com.deliveryacert.deliveryacertapi.domain.exception.PedidoRequisicaoInvalida;
import com.deliveryacert.deliveryacertapi.domain.exception.UsuarioNaoEncontrado;
import com.deliveryacert.deliveryacertapi.domain.model.Pedido;
import com.deliveryacert.deliveryacertapi.domain.model.Usuario;
import com.deliveryacert.deliveryacertapi.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioService usuarioService;

    public Pedido buscarOuFalhar(Long pedidoId) {
        return pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new PedidoNaoEncontrado(pedidoId));
    }

    public Pedido salvar(Pedido pedido) {
        try {
            Long usuarioId = pedido.getCliente_id().getId();
            Usuario usuario = usuarioService.buscarOuFalhar(usuarioId);
            pedido.setCliente_id(usuario);
        } catch (UsuarioNaoEncontrado | NullPointerException e) {
            throw new PedidoRequisicaoInvalida("É obrigatório informar um cliente para criar um pedido.");
        }

        return pedidoRepository.save(pedido);
    }

    public void excluir(Long pedidoId) {
        try {
            pedidoRepository.deleteById(pedidoId);
        } catch (EmptyResultDataAccessException e) {
            throw new PedidoNaoEncontrado(pedidoId);
        }
    }
}
