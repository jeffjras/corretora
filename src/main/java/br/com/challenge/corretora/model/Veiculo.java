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
@Entity(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
