package br.com.bruno.gs3.clientes.brunogs3backend.mapper;

import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.Cliente;
import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.EmailCliente;
import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.Telefone;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.ClienteDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.EmailDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.TelefoneDTO;

import java.util.Set;
import java.util.stream.Collectors;

public class ClienteMapper implements MapperGlobal<Cliente, ClienteDTO> {

    @Override
    public Cliente dtoToEntity(ClienteDTO dto) {
        return Cliente.builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .endereco(new EnderecoMapper().dtoToEntity(dto.getEndereco()))
                .emails(preencheEmailsDTOToEntity(dto.getEmails()))
                .telefones(preencheTelefonesDTOToEntity(dto.getTelefones()))
                .build();
    }



    @Override
    public ClienteDTO entityToDTO(Cliente entity) {
        return ClienteDTO.builder()
                .id(entity.getIdCliente())
                .nome(entity.getNome())
                .cpf(entity.getCpf())
                .endereco(new EnderecoMapper().entityToDTO(entity.getEndereco()))
                .emails(preencheEmailsEntityToDTO(entity.getEmails()))
                .telefones(preencheTelefonesEntityToDTO(entity.getTelefones()))
                .build();
    }

    private Set<Telefone> preencheTelefonesDTOToEntity(Set<TelefoneDTO> telefones) {
        return telefones.stream().map(telefoneDTO -> new TelefoneMapper().dtoToEntity(telefoneDTO)).collect(Collectors.toSet());
    }

    private Set<EmailCliente> preencheEmailsDTOToEntity(Set<EmailDTO> emails) {
        return emails.stream().map(emailDTO -> new EmailMapper().dtoToEntity(emailDTO)).collect(Collectors.toSet());
    }

    private Set<TelefoneDTO> preencheTelefonesEntityToDTO(Set<Telefone> telefones) {
        return telefones.stream().map(telefone -> new TelefoneMapper().entityToDTO(telefone)).collect(Collectors.toSet());
    }

    private Set<EmailDTO> preencheEmailsEntityToDTO(Set<EmailCliente> emails) {
        return emails.stream().map(email -> new EmailMapper().entityToDTO(email)).collect(Collectors.toSet());
    }
}
