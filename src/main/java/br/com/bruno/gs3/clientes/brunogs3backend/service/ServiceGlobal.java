package br.com.bruno.gs3.clientes.brunogs3backend.service;

import br.com.bruno.gs3.clientes.brunogs3backend.dto.DTO;

import java.util.List;

public interface ServiceGlobal<T extends DTO> {
    List<T> findAll();
    T getOne(String id) throws Exception;
    T update(String id, T dto) throws Exception;
    T create(T dto);
    void delete(String id);
}
