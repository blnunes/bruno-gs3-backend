package br.com.bruno.gs3.clientes.brunogs3backend.service.impl;

import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.Cliente;
import br.com.bruno.gs3.clientes.brunogs3backend.dao.repository.ClienteRepository;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.ClienteDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.mapper.ClienteMapper;
import br.com.bruno.gs3.clientes.brunogs3backend.service.ServiceGlobal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ClienteDTO update(String id, ClienteDTO dto) throws Exception {
        return null;
    }

    @Override
    public ClienteDTO create(ClienteDTO dto) {
       Cliente cliente = clienteRepository.save(new ClienteMapper().dtoToEntity(dto));
        return new ClienteMapper().entityToDTO(cliente);
    }

    @Override
    public void delete(String id) {

    }
}
