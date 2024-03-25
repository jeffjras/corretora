package br.com.challenge.corretora.model;

import jakarta.persistence.*;
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
public class Cotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCotacao;

    @ManyToOne
    @JoinColumn(name = "idCorretora")
    private Corretora corretora;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idVeiculo")
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "idSeguradora")
    private Seguradora seguradora;

    private String produto;

    private String numProposta;

    private String numApolice;

    private String dtTermino;

    private String dtProposta;

    private String dtInicioVigencia;

    private String dtEmissaoApolice;

    private int aprovada;

}
