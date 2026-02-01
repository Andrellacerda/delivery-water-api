package com.deliverywater.api.dto.entrega;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public record EntregaCreateDTO(
    @NotNull Long pedidoId,
    @NotNull LocalDateTime dataHora,
    @NotNull @Min(1) Integer quantidadeLitros
) {}