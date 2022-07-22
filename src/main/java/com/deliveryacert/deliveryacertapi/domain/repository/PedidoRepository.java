package com.deliveryacert.deliveryacertapi.domain.repository;

import com.deliveryacert.deliveryacertapi.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
