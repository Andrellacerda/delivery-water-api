package com.deliverywater.api.services;

import com.deliverywater.api.domain.*;
import com.deliverywater.api.dto.pedido.*;
import com.deliverywater.api.exceptions.*;
import com.deliverywater.api.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final CaminhaoRepository caminhaoRepository;

    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, CaminhaoRepository caminhaoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.caminhaoRepository = caminhaoRepository;
    }

    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    public Pedido criar(PedidoCreateDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado"));

                Caminhao caminhao = null;
                if (dto.caminhaoId() != null) {
                    caminhao = caminhaoRepository.findById(dto.caminhaoId())
                            .orElseThrow(() -> new NotFoundException("Caminhão não encontrado"));
                if (caminhao.getStatus() != StatusCaminhao.DISPONIVEL) {
                    throw new BadRequestException("Caminhão não está disponível");
                }
            }

        Pedido p = new Pedido();
        p.setCliente(cliente);
        p.setCaminhao(caminhao);
        p.setEnderecoEntrega(dto.enderecoEntrega());
        p.setQuantidadeLitros(dto.quantidadeLitros());
        p.setStatus(StatusPedido.CONCLUIDO);

        return pedidoRepository.save(p);
    }

    public Pedido obter(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new NotFoundException("Pedido não encontrado"));
    }

    public Pedido atualizarStatus(Long id, PedidoStatusUpdateDTO dto) {
        Pedido p = obter(id);
        p.setStatus(dto.status());
        return pedidoRepository.save(p);
    }
    public void remover(Long id) {
        if (!pedidoRepository.existsById(id)) throw new NotFoundException("Pedido não encontrado");
        pedidoRepository.deleteById(id);
    }
}