package com.deliverywater.api.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "caminhoes", uniqueConstraints = @UniqueConstraint(columnNames = "placa"))
public class Caminhao {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private Integer capacidadeLitros;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusCaminhao status = StatusCaminhao.DISPONIVEL;

    public Long getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getCapacidadeLitros() {
        return capacidadeLitros;
    }

    public StatusCaminhao getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setCapacidadeLitros(Integer capacidadeLitros) {
        this.capacidadeLitros = capacidadeLitros;
    }
    public void setStatus(StatusCaminhao status) {
        this.status = status;
    }
}