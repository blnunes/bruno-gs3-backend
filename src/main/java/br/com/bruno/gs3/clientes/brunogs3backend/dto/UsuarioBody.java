package br.com.bruno.gs3.clientes.brunogs3backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioBody {
    private String user;
    private String pass;
}
