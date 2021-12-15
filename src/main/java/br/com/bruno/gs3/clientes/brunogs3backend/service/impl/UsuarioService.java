package br.com.bruno.gs3.clientes.brunogs3backend.service.impl;

import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.Usuario;
import br.com.bruno.gs3.clientes.brunogs3backend.dao.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario getByUserPass(String user, String pass) throws AuthenticationException {
        return Optional
                .ofNullable(usuarioRepository.findUsuarioByUsuarioAndSenha(user.toLowerCase(), pass))
                .orElseThrow(() -> new AuthenticationException("Erro ao localizar usuário, verifique se seu login e senha estão corretos!"));
    }
}
