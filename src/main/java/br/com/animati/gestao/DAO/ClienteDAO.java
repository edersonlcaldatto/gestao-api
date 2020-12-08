package br.com.animati.gestao.DAO;

import br.com.animati.gestao.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDAO  extends JpaRepository<Cliente, Long> {

}
