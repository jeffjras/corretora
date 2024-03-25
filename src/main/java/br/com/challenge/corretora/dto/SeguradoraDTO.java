package br.com.challenge.corretora.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeguradoraDTO {
    private Long idSeguradora;

    private String cnpj;
    private Long codsusep;
    private Long email;
    private Long endereco;
    private Long nome;
    private Long telefone;
}
