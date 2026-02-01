package com.deliverywater.api.controllers;

import com.deliverywater.api.domain.Pedido;
import com.deliverywater.api.dto.pedido.*;
import com.deliverywater.api.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    
    private final PedidoService service;
    
    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pedido> listar() {
        return service.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido criar(@Valid @RequestBody PedidoCreateDTO dto) {
        return service.criar(dto);
    }

    @GetMapping("/{id}")
    public Pedido obter(@PathVariable Long id) {
        return service.obter(id);
    }

    @PutMapping("/{id}")
    public Pedido atualizarStatus(@PathVariable Long id, @Valid @RequestBody PedidoStatusUpdateDTO dto ) {
        return service.atualizarStatus(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }
}
