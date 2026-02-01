package com.deliverywater.api.repository;

import com.deliverywater.api.domain.Caminhao;
import com.deliverywater.api.domain.StatusCaminhao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {
    long countByStatus(StatusCaminhao status);
    boolean existsByPlaca(String placa);
    
}
