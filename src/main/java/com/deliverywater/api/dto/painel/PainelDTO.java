package com.deliverywater.api.dto.painel;

import com.deliverywater.api.domain.StatusCaminhao;
import com.deliverywater.api.domain.StatusPedido;
import java.util.Map;

public record PainelDTO(
    Map<StatusPedido, Long> pedidosPorStatus,
    Map<StatusCaminhao, Long> caminhoesPorStatus
    
    
) {}