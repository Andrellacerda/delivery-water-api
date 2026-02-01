package com.deliverywater.api.controllers;

import com.deliverywater.api.domain.Caminhao;
import com.deliverywater.api.dto.caminhao.*;
import com.deliverywater.api.services.CaminhaoService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caminhoes")
public class CaminhaoController {

    private final CaminhaoService service;

    public CaminhaoController(CaminhaoService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Caminhao criar(@Valid @RequestBody CaminhaoCreateDTO dto) {
        return service.criar(dto);
    }

    @GetMapping("/{id}")
    public Caminhao obter(@PathVariable Long id) {
        return service.obter(id);
    }

    @PutMapping("/{id}")
    public Caminhao atualizar(@PathVariable Long id, @Valid @RequestBody CaminhaoUpdateDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }
    
}
