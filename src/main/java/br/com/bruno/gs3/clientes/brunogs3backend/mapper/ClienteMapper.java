package br.com.bruno.gs3.clientes.brunogs3backend.mapper;

import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.Cliente;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.ClienteDTO;

public class ClienteMapper implements MapperGlobal<Cliente, ClienteDTO> {

    @Override
    public Cliente dtoToEntity(ClienteDTO dto) {
        return Cliente.builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .endereco(new EnderecoMapper().dtoToEntity(dto.getEnderecoDTO()))
                .build();
    }

    @Override
    public ClienteDTO entityToDTO(Cliente entity) {
        return ClienteDTO.builder()
                .id(entity.getIdCliente())
                .nome(entity.getNome())
                .cpf(entity.getCpf())
                .enderecoDTO(new EnderecoMapper().entityToDTO(entity.getEndereco()))
                .build();
    }
}
