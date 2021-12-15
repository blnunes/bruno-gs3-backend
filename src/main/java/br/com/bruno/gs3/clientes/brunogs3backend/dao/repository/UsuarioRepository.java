package br.com.bruno.gs3.clientes.brunogs3backend.dao.repository;

import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findUsuarioByUsuarioAndSenha(String usuario, String senha);
}
