package com.deliverywater.api.dto.cliente;

public record ClienteUpdateDTO(
    String nome,
    String endereco,
    String telefone
) {}