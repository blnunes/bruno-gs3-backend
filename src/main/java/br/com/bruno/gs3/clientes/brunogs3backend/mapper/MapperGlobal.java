package br.com.bruno.gs3.clientes.brunogs3backend.mapper;

import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.EntityGlobal;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.DTO;
import br.com.bruno.gs3.clientes.brunogs3backend.forms.FormGlobal;

import java.util.List;

public interface MapperGlobal<T extends EntityGlobal, R extends DTO, S extends FormGlobal> {
    T dtoToEntity(R dto);
    R entityToDTO(T entity);
    S dtoToForm(R dto);

}
