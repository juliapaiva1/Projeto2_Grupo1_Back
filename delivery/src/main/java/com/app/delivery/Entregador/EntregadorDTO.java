package com.app.delivery.Entregador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String tipo_veiculo;
    private Double preco_viagem;
    private EntregadorOcupacao status_ocupacao;
    private EntregadorUtilizacao status_utilizacao;

    public EntregadorDTO (Entregador entregador){
        this.id = entregador.getId();
        this.nome = entregador.getNome();
        this.cpf = entregador.getCpf();
        this.tipo_veiculo = entregador.getTipo_veiculo();
        this.preco_viagem = entregador.getPreco_viagem();
        this.status_ocupacao = entregador.getStatus_ocupacao();
        this.status_utilizacao = entregador.getStatus_utilizacao();
    }

    public static List<EntregadorDTO> converter(List<Entregador> entregadores) {
        return entregadores.stream().map(EntregadorDTO::new).collect(Collectors.toList());
    }

}