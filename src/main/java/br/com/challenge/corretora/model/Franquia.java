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
@Entity(name = "franquia")
public class Franquia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFranquia;
    private String descricao;
    private String tipo;
    private Double valor;
}
