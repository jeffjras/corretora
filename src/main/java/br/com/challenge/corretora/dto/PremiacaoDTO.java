package br.com.challenge.corretora.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PremiacaoDTO {
    private Long idPremiacao;

    private Double iof;

    private Double premioLiquido;

    private Double premioTotal;
}
