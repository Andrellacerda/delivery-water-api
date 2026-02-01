package com.deliverywater.api.dto.caminhao;

import jakarta.validation.constraints.*;

public record CaminhaoCreateDTO( 

    @NotBlank String placa,
    @NotBlank String modelo,
    @NotBlank @Min(1) Integer capacidadeLitros
    )
    
{}