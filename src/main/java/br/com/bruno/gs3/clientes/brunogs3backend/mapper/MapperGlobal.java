package br.com.bruno.gs3.clientes.brunogs3backend.mapper;

import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.EntityGlobal;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.DTO;

public interface MapperGlobal<T extends EntityGlobal, R extends DTO> {
    T dtoToEntity(R dto);
    R entityToDTO(T entity);
}
