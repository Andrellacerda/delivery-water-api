package com.deliverywater.api.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "entregas")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false)
    private Integer quantidadeEntregueLitros;

    public Long getId() {
        return id;
    }
    public Pedido getPedido() {
        return pedido;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public Integer getQuantidadeEntregueLitros() {
        return quantidadeEntregueLitros;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    public void setQuantidadeEntregueLitros(Integer quantidadeEntregueLitros) {
        this.quantidadeEntregueLitros = quantidadeEntregueLitros;
    }
    
}
