package br.com.bruno.gs3.clientes.brunogs3backend.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.NUMBER)
public enum TipoTelefoneEnum {
    RESIDENCIAL(1,8,"Residencial"),
    COMERCIAL(2,8,"Comercial"),
    CELULAR(3,9,"Celular");

    private Integer id;

    @NotNull(message = "Tipo telefone obrigatorio")
    private Integer quantidadeDigitos;
    private String desc;
}
