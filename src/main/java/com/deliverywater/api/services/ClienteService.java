package com.deliverywater.api.services;

import com.deliverywater.api.domain.Cliente;
import com.deliverywater.api.dto.cliente.*;
import com.deliverywater.api.exceptions.NotFoundException;
import com.deliverywater.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<Cliente> listar() {
        return repo.findAll();
    }

    public Cliente criar(ClienteCreateDTO dto) {
        Cliente c = new Cliente();
        c.setNome(dto.nome());
        c.setEndereco(dto.endereco());
        c.setTelefone(dto.telefone());
        return repo.save(c);
        }

        public Cliente obter(Long id) {
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Cliente não encontrado"));
        }

        public Cliente atualizar(Long id, ClienteUpdateDTO dto) {
        Cliente c = obter(id);
        if (dto.nome() != null) c.setNome(dto.nome());
        if (dto.endereco() != null) c.setEndereco(dto.endereco());
        if (dto.telefone() != null) c.setTelefone(dto.telefone());
        return repo.save(c);
        }

        public void remover (Long id) {
            if (!repo.existsById(id)) throw new NotFoundException("Cliente não encontrado");
            repo.deleteById(id);
            }
    
}
