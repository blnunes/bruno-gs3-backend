package br.com.bruno.gs3.clientes.brunogs3backend.service.impl;

import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.Cliente;
import br.com.bruno.gs3.clientes.brunogs3backend.dao.repository.ClienteRepository;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.ClienteDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.mapper.ClienteMapper;
import br.com.bruno.gs3.clientes.brunogs3backend.mapper.EmailMapper;
import br.com.bruno.gs3.clientes.brunogs3backend.mapper.TelefoneMapper;
import br.com.bruno.gs3.clientes.brunogs3backend.service.ServiceGlobal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.List;

@Service
public class ClienteService implements ServiceGlobal<ClienteDTO> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> findAll() {
        return null;
    }

    @Override
    public ClienteDTO getOne(String id) throws Exception {
        return null;
    }

    @Override
    public ClienteDTO update(String id, ClienteDTO dto) throws NotFoundException {
        if (clienteRepository.existsById(Long.valueOf(id))) {
            Cliente cliente = new ClienteMapper().dtoToEntity(dto);
            cliente.setEmails(new EmailMapper().listDtoToEntity(dto.getEmails()));
            cliente.setTelefones(new TelefoneMapper().listDtoToEntity(dto.getTelefones()));
            return new ClienteMapper().entityToDTO(clienteRepository.save(new ClienteMapper().dtoToEntity(dto)));
        }
        throw new NotFoundException("Cliente: " + dto.getCpf() + " não encontrado!");
    }

    @Override
    public ClienteDTO create(ClienteDTO dto) {
        try {
            Cliente cliente = clienteRepository.save(new ClienteMapper().dtoToEntity(dto));
            return new ClienteMapper().entityToDTO(cliente);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateKeyException("CPF: "+dto.getCpf()+" já cadastrado");
        }
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<ClienteDTO> addAll(List<ClienteDTO> listDTO) {
        return null;
    }

}
