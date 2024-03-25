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
public class CotacaoDTO {
    private Long idCotacao;

    private CorretoraDTO corretora;

    private ClienteDTO cliente;

    private VeiculoDTO veiculo;

    private SeguradoraDTO seguradora;

    private String produto;

    private String numProposta;

    private String numApolice;

    private String dtTermino;

    private String dtProposta;

    private String dtInicioVigencia;

    private String dtEmissaoApolice;

    private int aprovada;
}
