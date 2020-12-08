package br.com.animati.gestao.DAO;

import br.com.animati.gestao.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoDAO extends JpaRepository<Projeto, Long> {
}
