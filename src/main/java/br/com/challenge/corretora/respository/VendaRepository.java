package br.com.challenge.corretora.respository;

import br.com.challenge.corretora.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    @Query(value = "select v "
            + "from venda v "
            + "join cotacao co on v.cotacao.idCotacao = co.idCotacao "
            + "where v.idCotacao = :idCotacao ")
    public List<Venda> getVendaByCotacao(long idCotacao);

    public Venda findByVendaIdentifier(String vendaIdentifier);

    Optional<Venda> findByCode(String code);
}
