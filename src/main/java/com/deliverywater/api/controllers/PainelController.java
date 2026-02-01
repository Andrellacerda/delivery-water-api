package com.deliverywater.api.controllers;

import com.deliverywater.api.dto.painel.PainelDTO;
import com.deliverywater.api.services.PainelService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/painel")
public class PainelController {

    private final PainelService service;

    public PainelController(PainelService service) {
        this.service = service;
    }

    @GetMapping
    public PainelDTO obter() {
        return service.obterPainel();
    }    
}
