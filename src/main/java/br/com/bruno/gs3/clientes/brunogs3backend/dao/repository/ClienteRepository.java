package br.com.bruno.gs3.clientes.brunogs3backend.dao.repository;

import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
