package com.app.delivery.Entregador;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Entregador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //usar como identifier
    @Column
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100)
    private String nome;

    @Column
    @NotBlank(message = "CPF é obrigatório")
    @CPF
    private String cpf;

    @Column
    @NotBlank(message = "Tipo de veículo é obrigatório")
    private String tipo_veiculo;

    @Column
    private Double preco_viagem;

    @Column
    @Enumerated(EnumType.STRING)
    private EntregadorOcupacao status_ocupacao;

    @Column
    @Enumerated(EnumType.STRING)
    private EntregadorUtilizacao status_utilizacao;

}