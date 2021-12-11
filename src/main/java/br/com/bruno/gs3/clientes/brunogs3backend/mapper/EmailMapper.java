package br.com.bruno.gs3.clientes.brunogs3backend.mapper;

import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.EmailCliente;
import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.Endereco;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.EmailDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.EnderecoDTO;

public class EmailMapper implements MapperGlobal<EmailCliente, EmailDTO> {

    @Override
    public EmailCliente dtoToEntity(EmailDTO dto) {
        return EmailCliente.builder()
                .email(dto.getEmail())
                .build();
    }

    @Override
    public EmailDTO entityToDTO(EmailCliente entity) {
        return EmailDTO.builder()
                .email(entity.getEmail())
                .build();
    }
}
