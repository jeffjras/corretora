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
@Entity(name = "premiacao")
public class Premiacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPremiacao;

    private Double iof;

    private Double premioLiquido;

    private Double premioTotal;

}
