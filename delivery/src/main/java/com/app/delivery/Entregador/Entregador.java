package com.app.delivery.Entregador;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Entregador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //usar como identifier
    @Column
    private String nome;

    @Column
    private String cpf;

    @Column
    private String tipo_veiculo;

    @Column
    private Double preco_viagem;

    @Column
    private EntregadorOcupacao status_ocupacao;

    @Column
    private EntregadorUtilizacao status_utilizacao;

}