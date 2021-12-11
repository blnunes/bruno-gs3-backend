package br.com.bruno.gs3.clientes.brunogs3backend.dao.repository;

import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.Cliente;
import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.EmailCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailCliente, Long> {

}
