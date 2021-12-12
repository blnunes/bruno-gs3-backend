package br.com.bruno.gs3.clientes.brunogs3backend.mapper;

import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.Cliente;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.ClienteDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.forms.ClienteForm;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteMapper implements MapperGlobal<Cliente, ClienteDTO, ClienteForm> {

    @Override
    public Cliente dtoToEntity(ClienteDTO dto) {

        return Cliente.builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .endereco(new EnderecoMapper().dtoToEntity(dto.getEndereco()))
                .build();
    }


    @Override
    public ClienteDTO entityToDTO(Cliente entity) {
        return ClienteDTO.builder()
                .id(entity.getIdCliente())
                .nome(entity.getNome())
                .cpf(entity.getCpf())
                .endereco(new EnderecoMapper().entityToDTO(entity.getEndereco()))
                .build();
    }

    @Override
    public ClienteForm dtoToForm(ClienteDTO dto) {
        return ClienteForm.builder()
                .idCliente(dto.getId())
                .cpf(dto.getCpf())
                .nome(dto.getNome())
                .endereco(new EnderecoMapper().dtoToForm(dto.getEndereco()))
                .telefones(dto.getTelefones().stream().map(telefoneDTO ->
                        new TelefoneMapper().dtoToForm(telefoneDTO)).collect(Collectors.toList()))
                .emails(dto.getEmails().stream().map(emailDTO ->
                        new EmailMapper().dtoToForm(emailDTO)).collect(Collectors.toList()))
                .build();
    }

    @Override
    public List<Cliente> listDtoToEntity(List<ClienteDTO> dto) {
        return null;
    }

    @Override
    public List<ClienteDTO> listEntityToDTO(List<Cliente> entity) {
        return null;
    }


}
