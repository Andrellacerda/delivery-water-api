package com.deliverywater.api.controllers;

import com.deliverywater.api.domain.Cliente;
import com.deliverywater.api.dto.cliente.*;
import com.deliverywater.api.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente criar(@Valid @RequestBody ClienteCreateDTO dto) {
        return service.criar(dto);
    }

    @GetMapping("/{id}")
    public Cliente obter(@PathVariable Long id) {
        return service.obter(id);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody ClienteUpdateDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }
    
}
