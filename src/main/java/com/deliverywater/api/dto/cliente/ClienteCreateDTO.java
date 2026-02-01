package com.deliverywater.api.dto.cliente;

import jakarta.validation.constraints.NotBlank;

public record ClienteCreateDTO(
    @NotBlank String nome,
    @NotBlank String endereco,
    @NotBlank String telefone
) {}