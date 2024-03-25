package br.com.challenge.corretora.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoDTO {

    private Long idPagamento;

    private ParcelaDTO parcela;

    private LocalDateTime dtVenctoParcela;

    private String formaPagto;

    private int qtdeParcela;

    private Double taxaJuros;

    private Double valorPrimeieraParcela;
}
