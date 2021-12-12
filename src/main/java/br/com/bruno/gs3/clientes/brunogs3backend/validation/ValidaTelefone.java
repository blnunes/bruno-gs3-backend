package br.com.bruno.gs3.clientes.brunogs3backend.validation;

import br.com.bruno.gs3.clientes.brunogs3backend.dto.TelefoneDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidaTelefone implements ConstraintValidator<ValidadorTelefone, TelefoneDTO> {

    @Override
    public boolean isValid(TelefoneDTO value, ConstraintValidatorContext context) {
        if(value.getTipoTelefone() != null){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("" +
                            "A quantidade correta de digitos para telefone "+value.getTipoTelefone().getDesc()+" são: "+value.getTipoTelefone().getQuantidadeDigitos())
                    .addConstraintViolation();
            return value.getTipoTelefone().getQuantidadeDigitos() == value.getNumero().length();
        }
        return true;
    }
}
