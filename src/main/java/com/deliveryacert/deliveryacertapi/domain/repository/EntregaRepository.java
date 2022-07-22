package com.deliveryacert.deliveryacertapi.domain.repository;

import com.deliveryacert.deliveryacertapi.domain.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
