package br.com.challenge.corretora.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"code"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenda;

    @ManyToOne
    @JoinColumn(name = "idCotacao")
    private Cotacao cotacao;

    @ManyToOne
    @JoinColumn(name = "idFranquia")
    private Franquia franquia;

    @ManyToOne
    @JoinColumn(name = "idPagamento")
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "idPremiacao")
    private Premiacao premiacao;

    @ManyToOne
    @JoinColumn(name = "idVeiculo")
    private Veiculo veiculo;

    private String dtEmissao;
    private Double valor;
    private String code;
    private int transmitida;
}
