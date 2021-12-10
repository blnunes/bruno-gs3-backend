package br.com.bruno.gs3.clientes.brunogs3backend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTelefoneEnum {
    RESIDENCIAL(1,8,"Residencial"),
    COMERCIAL(2,8,"Comercial"),
    CELULAR(3,9,"Celular");

    private Integer id;
    private Integer quantidadeDigitos;
    private String desc;
}
