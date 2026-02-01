package com.deliverywater.api.controllers;

import com.deliverywater.api.domain.Entrega;
import com.deliverywater.api.dto.entrega.EntregaCreateDTO;
import com.deliverywater.api.services.EntregaService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private final EntregaService service;

    public EntregaController(EntregaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega registrar(@Valid @RequestBody EntregaCreateDTO dto) {
        return service.registrar(dto);
    }

    @GetMapping
    public List<Entrega> listar() {
        return service.listar();
    }
    
}
