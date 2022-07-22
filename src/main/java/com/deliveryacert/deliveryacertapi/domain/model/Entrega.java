package com.deliveryacert.deliveryacertapi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Status status;
    private LocalDateTime dataEntrega;

    @OneToOne
    @JoinColumn(nullable = false, name = "pedido_id")
    private Pedido pedido_id;
}
