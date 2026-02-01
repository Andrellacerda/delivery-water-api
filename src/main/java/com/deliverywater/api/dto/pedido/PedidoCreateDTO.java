package com.deliverywater.api.dto.pedido;

import jakarta.validation.constraints.*;

public record PedidoCreateDTO(
    @NotNull Long clienteId,
    @NotBlank String enderecoEntrega,
    @NotNull @Min(1) Integer quantidadeLitros,
    Long caminhaoId
) {}