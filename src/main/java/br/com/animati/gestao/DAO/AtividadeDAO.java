package br.com.animati.gestao.DAO;

import br.com.animati.gestao.entity.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtividadeDAO extends JpaRepository<Atividade, Long> {
}
