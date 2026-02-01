package com.deliverywater.api.dto.caminhao;

import com.deliverywater.api.domain.StatusCaminhao;
import jakarta.validation.constraints.Min;

public record CaminhaoUpdateDTO(
    StatusCaminhao status,
    @Min(1) Integer capacidadeLitros
) {}