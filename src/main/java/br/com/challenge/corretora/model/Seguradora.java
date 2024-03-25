package br.com.challenge.corretora.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "seguradora")
public class Seguradora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeguradora;

    private String cnpj;
    private Long codsusep;
    private Long email;
    private Long endereco;
    private Long nome;
    private Long telefone;
}
