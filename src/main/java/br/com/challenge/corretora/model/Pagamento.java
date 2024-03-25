package br.com.challenge.corretora.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPagamento;

    @ManyToOne
    @JoinColumn(name = "idParcela")
    private Parcela parcela;

    private LocalDateTime dtVenctoParcela;

    private String formaPagto;

    private int qtdeParcela;

    private Double taxaJuros;

    private Double valorPrimeieraParcela;
}
