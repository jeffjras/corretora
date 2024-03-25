package br.com.challenge.corretora.dto;

import br.com.challenge.corretora.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VendaDTO {
    private Long idVenda;

    private CotacaoDTO cotacao;

    private FranquiaDTO franquia;

    private PagamentoDTO pagamento;

    private PremiacaoDTO premiacao;

    private VeiculoDTO veiculo;

    private String dtEmissao;

    private Double valor;

    private int transmitida;
}
