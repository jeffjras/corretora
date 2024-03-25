package br.com.challenge.corretora.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoDTO {
    private Long idVeiculo;

    private String idPerfilVeiculo;

    private String anoFabricacao;
    private String capacidade;
    private String categoriaTarifaria;

    private String chassi;

    private String isencao;

    private String marcaModelo;

    private String placa;

    private String zerokm;
}
