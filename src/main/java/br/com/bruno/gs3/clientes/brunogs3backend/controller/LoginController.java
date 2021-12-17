package br.com.bruno.gs3.clientes.brunogs3backend.controller;

import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.Usuario;
import br.com.bruno.gs3.clientes.brunogs3backend.enums.TipoTransacaoEnum;
import br.com.bruno.gs3.clientes.brunogs3backend.service.impl.HistoricoService;
import br.com.bruno.gs3.clientes.brunogs3backend.service.impl.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("autenticar-login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private HistoricoService historicoService;

    @GetMapping
    @CrossOrigin
    public ResponseEntity<Usuario> login(@RequestParam String user, @RequestParam String pass) throws AuthenticationException {
        Usuario byUserPass = usuarioService.getByUserPass(user, pass);
        historicoService.gravaHistorico(user, TipoTransacaoEnum.LOGIN);
        return new ResponseEntity<>(byUserPass, HttpStatus.OK);
    }
}
