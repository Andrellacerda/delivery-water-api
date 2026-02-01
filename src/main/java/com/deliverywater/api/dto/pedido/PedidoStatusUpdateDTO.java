package com.deliverywater.api.dto.pedido;

import com.deliverywater.api.domain.StatusPedido;
import jakarta.validation.constraints.NotNull;

public record PedidoStatusUpdateDTO(
    @NotNull StatusPedido status
) {}