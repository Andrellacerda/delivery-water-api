package com.deliverywater.api.dto.caminhao;

import jakarta.validation.constraints.*;

public record CaminhaoCreateDTO( 

    @NotBlank(message = "Placa obrigatória")
    String placa,

    @NotBlank(message = "Modelo obrigatório")
    String modelo,

    @NotNull(message = "Capacidade em litros obrigatória")
    @Min(value = 1, message = "Capacidade em litros deve ser maior que zero")
    Integer capacidadeLitros
    )
    
{}