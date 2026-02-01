package com.deliverywater.api.repository;

import com.deliverywater.api.domain.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
    
}
