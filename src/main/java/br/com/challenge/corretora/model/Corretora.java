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
@Entity(name = "cotacao")
public class Corretora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCorretora;
    private String codsusep;
    private String cpfcnpj;
    private String endereco;
    private String nome;
    private String telefone;

}
