package com.deliverywater.api.repository;

import com.deliverywater.api.domain.Pedido;
import com.deliverywater.api.domain.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    long countByStatus(StatusPedido status);
}