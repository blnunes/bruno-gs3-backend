package br.com.bruno.gs3.clientes.brunogs3backend.service.impl;

import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.EmailCliente;
import br.com.bruno.gs3.clientes.brunogs3backend.dao.repository.EmailRepository;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.ClienteDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.EmailDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.mapper.EmailMapper;
import br.com.bruno.gs3.clientes.brunogs3backend.mapper.TelefoneMapper;
import br.com.bruno.gs3.clientes.brunogs3backend.service.ServiceGlobal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmailService implements ServiceGlobal<EmailDTO> {

    @Autowired
    private EmailRepository emailRepository;

    @Override
    public List<EmailDTO> findAll() {
        return null;
    }

    @Override
    public EmailDTO getOne(String id) throws Exception {
        return null;
    }

    @Override
    public EmailDTO update(String id, EmailDTO dto) throws NotFoundException {
        return null;
    }

    @Override
    public EmailDTO create(EmailDTO dto) {
        EmailCliente email = emailRepository.save(new EmailMapper().dtoToEntity(dto));
        return new EmailMapper().entityToDTO(email);
    }

    public List<EmailDTO> cadastraEmail(List<EmailDTO> listEmail, ClienteDTO clienteDTO) {
        return listEmail.stream().map(emailDTO -> {
            emailDTO.setClienteDTO(clienteDTO);
            return create(emailDTO);
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<EmailDTO> addAll(List<EmailDTO> listDTO) {
        return new EmailMapper().listEntityToDTO(emailRepository.saveAll(new EmailMapper().listDtoToEntity(listDTO)));
    }

}
