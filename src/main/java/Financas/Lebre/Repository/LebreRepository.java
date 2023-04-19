package Financas.Lebre.Repository;

import Financas.Lebre.Model.Ativos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LebreRepository extends JpaRepository<Ativos,Integer> {
    public boolean existsBynomeAtivo(String nomeAtivo);
}
