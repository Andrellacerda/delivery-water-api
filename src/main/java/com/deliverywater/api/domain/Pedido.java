package com.deliverywater.api.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(nullable = false)
    private String enderecoEntrega;

    @Column(nullable = false)
    private Integer quantidadeLitros;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caminhao_id")
    private Caminhao caminhao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPedido status = StatusPedido.CONCLUIDO;

    @Column(nullable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    public Long getId() {
        return id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }
    public Integer getQuantidadeLitros() {
        return quantidadeLitros;
    }
    public Caminhao getCaminhao() {
        return caminhao;
    }
    public StatusPedido getStatus() {
        return status;
    }
    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }
    public void setQuantidadeLitros(Integer quantidadeLitros) {
        this.quantidadeLitros = quantidadeLitros;
    }
    public void setCaminhao(Caminhao caminhao) {
        this.caminhao = caminhao;
    }
    public void setStatus(StatusPedido status) {
        this.status = status;
    }
    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    
}
