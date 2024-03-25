package br.com.challenge.corretora.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CorretoraDTO {
    private Long idCorretora;
    private String codsusep;
    private String cpfCnpj;
    private String endereco;
    private String nome;
    private String telefone;
}
