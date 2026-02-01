package com.deliverywater.api.services;

import com.deliverywater.api.domain.Caminhao;
import com.deliverywater.api.dto.caminhao.*;
import com.deliverywater.api.exceptions.*;
import com.deliverywater.api.repository.CaminhaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaminhaoService {

    private final CaminhaoRepository repo;

    public CaminhaoService(CaminhaoRepository repo) {
        this.repo = repo;
    }

    public List<Caminhao> listar() {
        return repo.findAll();
    }

    public Caminhao criar(CaminhaoCreateDTO dto) {
        if (repo.existsByPlaca(dto.placa())) {
            throw new BadRequestException("Já existe um caminhão com a placa informada.");
        }
        Caminhao c = new Caminhao();
        c.setPlaca(dto.placa());
        c.setModelo(dto.modelo());
        c.setCapacidadeLitros(dto.capacidadeLitros());
        return repo.save(c);
    }

    public Caminhao obter(Long id) {
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Caminhão não encontrado."));
    }

    public Caminhao atualizar(Long id, CaminhaoUpdateDTO dto) {
        Caminhao c = obter(id);
        if (dto.capacidadeLitros() != null) c.setCapacidadeLitros(dto.capacidadeLitros());
        if (dto.status() != null) c.setStatus(dto.status());            
        return repo.save(c);
    }

    public void remover(Long id) {
        if (!repo.existsById(id)) throw new NotFoundException("Caminhão não encontrado.");
        repo.deleteById(id);
    }
    
}
