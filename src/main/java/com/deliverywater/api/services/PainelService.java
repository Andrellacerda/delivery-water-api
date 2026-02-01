package com.deliverywater.api.services;

import com.deliverywater.api.domain.StatusPedido;
import com.deliverywater.api.domain.StatusCaminhao;
import com.deliverywater.api.dto.painel.PainelDTO;
import com.deliverywater.api.repository.CaminhaoRepository;
import com.deliverywater.api.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.Map;

@Service
public class PainelService {

    private final PedidoRepository pedidoRepository;
    private final CaminhaoRepository caminhaoRepository;

    public PainelService(PedidoRepository pedidoRepository, CaminhaoRepository caminhaoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.caminhaoRepository = caminhaoRepository;
    }

    public PainelDTO obterPainel() {

        // Contar pedidos por status
        Map<StatusPedido, Long> pedidoMap = new EnumMap<>(StatusPedido.class);
        for (StatusPedido s : StatusPedido.values()) {
            pedidoMap.put(s, pedidoRepository.countByStatus(s));
        }
        
        // Contar caminhões por status
        Map<StatusCaminhao, Long> caminhaoMap = new EnumMap<>(StatusCaminhao.class);
        for (StatusCaminhao s : StatusCaminhao.values()) {
            caminhaoMap.put(s, caminhaoRepository.countByStatus(s));
        }
         
        return new PainelDTO(pedidoMap, caminhaoMap);
    }    
}