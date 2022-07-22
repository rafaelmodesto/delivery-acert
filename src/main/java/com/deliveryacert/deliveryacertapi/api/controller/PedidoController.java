package com.deliveryacert.deliveryacertapi.api.controller;

import com.deliveryacert.deliveryacertapi.domain.model.Pedido;
import com.deliveryacert.deliveryacertapi.domain.repository.PedidoRepository;
import com.deliveryacert.deliveryacertapi.domain.service.PedidoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/{pedidoId}")
    public Pedido buscar(@PathVariable Long pedidoId) {
        return pedidoService.buscarOuFalhar(pedidoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido adicionar(@RequestBody Pedido pedido) {
        return pedidoService.salvar(pedido);
    }

    @PutMapping("/{pedidoId}")
    public Pedido atualizar(@PathVariable Long pedidoId, @RequestBody Pedido pedido) {
        Pedido pedidoAtual = pedidoService.buscarOuFalhar(pedidoId);

        BeanUtils.copyProperties(pedido, pedidoAtual,"id", "dataCriacao");

        return pedidoService.salvar(pedidoAtual);
    }

    @DeleteMapping("/{pedidoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long pedidoId) {
        pedidoService.excluir(pedidoId);
    }

}
