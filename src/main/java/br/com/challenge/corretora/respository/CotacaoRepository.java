package br.com.challenge.corretora.respository;

import br.com.challenge.corretora.model.Cotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CotacaoRepository extends JpaRepository<Cotacao, Long> {

    @Query(value = "select c "
            + "from cotacao c "
            + "join corretora co on c.corretora.idCorretora = c.idCorretora "
            + "where c.idCorretora = :idCorretora ")
    public List<Cotacao> getCotacaoByCorretora(long idCorretora);

    public Cotacao findByCotacaoIdentifier(String cotacaoIdentifier);
}
