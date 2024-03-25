package br.com.challenge.corretora.respository;

import br.com.challenge.corretora.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
