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
    private Integer id;

    //usar como identifier
    private String nome;

    private String cpf;

    private String tipo_veiculo;

    private Double preco_viagem;

    private EntregadorOcupacao status_ocupacao;

    private EntregadorUtilizacao status_utilizacao;

}