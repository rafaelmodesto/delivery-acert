package com.deliveryacert.deliveryacertapi.domain.service;

import com.deliveryacert.deliveryacertapi.domain.exception.EntregaNaoEncontrada;
import com.deliveryacert.deliveryacertapi.domain.exception.EntregaRequisicaoInvalida;
import com.deliveryacert.deliveryacertapi.domain.exception.PedidoNaoEncontrado;
import com.deliveryacert.deliveryacertapi.domain.model.Entrega;
import com.deliveryacert.deliveryacertapi.domain.model.Pedido;
import com.deliveryacert.deliveryacertapi.domain.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class EntregaService {
    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    private PedidoService pedidoService;

    public Entrega buscarOuFalhar(Long entregaId) {
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntregaNaoEncontrada(entregaId));
    }

    public Entrega salvar(Entrega entrega) {
        try {
            Long pedidoId = entrega.getPedido_id().getId();
            Pedido pedido = pedidoService.buscarOuFalhar(pedidoId);
            entrega.setPedido_id(pedido);
        } catch (PedidoNaoEncontrado | NullPointerException e) {
            throw new EntregaRequisicaoInvalida("É obrigatório informar um pedido para criar uma entrega.");
        }


        return entregaRepository.save(entrega);
    }

    public void excluir(Long entregaId) {
        try {
            entregaRepository.deleteById(entregaId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntregaNaoEncontrada(entregaId);
        }
    }
}
