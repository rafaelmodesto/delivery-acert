package com.deliveryacert.deliveryacertapi.domain.repository;

import com.deliveryacert.deliveryacertapi.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
