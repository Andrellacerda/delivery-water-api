package com.deliverywater.api.services;

import com.deliverywater.api.domain.*;
import com.deliverywater.api.dto.entrega.EntregaCreateDTO;
import com.deliverywater.api.exceptions.*;
import com.deliverywater.api.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaService {

    private final EntregaRepository entregaRepository;
    private final PedidoRepository pedidoRepository;

    public EntregaService(EntregaRepository entregaRepository, PedidoRepository pedidoRepository) {
        this.entregaRepository = entregaRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public Entrega registrar(EntregaCreateDTO dto) {
        Pedido pedido = pedidoRepository.findById(dto.pedidoId())
                .orElseThrow(() -> new NotFoundException("Pedido não encontrado"));

                if (pedido.getStatus() == StatusPedido.CANCELADO) {
                    throw new BadRequestException("Não é possível registrar entrega para um pedido cancelado");
                }

        Entrega e = new Entrega();
        e.setPedido(pedido);
        e.setDataHora(dto.dataHora());
        e.setQuantidadeEntregueLitros(dto.quantidadeLitros());

        // regra simples: ao registrar uma entrega, o status do pedido muda para CONCLUIDO
        pedido.setStatus(StatusPedido.CONCLUIDO);
        pedidoRepository.save(pedido);

        return entregaRepository.save(e);
    }

    public List<Entrega> listar() {
        return entregaRepository.findAll();
    }
}
