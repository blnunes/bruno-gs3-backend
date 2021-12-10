package br.com.bruno.gs3.clientes.brunogs3backend.mapper;

import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.Endereco;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.EnderecoDTO;

public class EnderecoMapper implements MapperGlobal<Endereco, EnderecoDTO> {

    @Override
    public Endereco dtoToEntity(EnderecoDTO dto) {
        return Endereco.builder()
                .bairro(dto.getBairro())
                .cep(dto.getCep())
                .cidade(dto.getCidade())
                .complemento(dto.getComplemento())
                .logradouro(dto.getLogradouro())
                .uf(dto.getUf())
                .build();
    }

    @Override
    public EnderecoDTO entityToDTO(Endereco entity) {
        return EnderecoDTO.builder()
                .id(entity.getId())
                .bairro(entity.getBairro())
                .cep(entity.getCep())
                .cidade(entity.getCidade())
                .complemento(entity.getComplemento())
                .logradouro(entity.getLogradouro())
                .uf(entity.getUf())
                .build();
    }
}
