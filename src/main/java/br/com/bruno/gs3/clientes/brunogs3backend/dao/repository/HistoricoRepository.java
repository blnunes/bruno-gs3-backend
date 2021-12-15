package br.com.bruno.gs3.clientes.brunogs3backend.dao.repository;

import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.HistoricoTransacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoRepository extends JpaRepository<HistoricoTransacao, Long> {

}
