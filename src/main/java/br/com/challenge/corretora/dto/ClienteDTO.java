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
public class ClienteDTO {
    private Long idCliente;
    private String tipo;
    private String cpfCnpj;
    private String nome;
    private String sexo;
    private String endereco;
    private String telefone;
    private String dtNasc;
    private String estadoCivil;
    private String email;
}
