package br.com.bruno.gs3.clientes.brunogs3backend.mapper;

import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.EmailCliente;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.EmailDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.forms.EmailForm;

import java.util.List;
import java.util.stream.Collectors;

public class EmailMapper implements MapperGlobal<EmailCliente, EmailDTO, EmailForm> {

    @Override
    public EmailCliente dtoToEntity(EmailDTO dto) {
        return EmailCliente.builder()
                .email(dto.getEmail())
                .build();
    }

    @Override
    public EmailDTO entityToDTO(EmailCliente entity) {
        return EmailDTO.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .build();
    }

    @Override
    public EmailForm dtoToForm(EmailDTO dto) {
        return EmailForm.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .build();
    }




}
