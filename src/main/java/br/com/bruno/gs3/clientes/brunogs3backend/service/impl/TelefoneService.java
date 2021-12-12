package br.com.bruno.gs3.clientes.brunogs3backend.service.impl;

import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.EmailCliente;
import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.Telefone;
import br.com.bruno.gs3.clientes.brunogs3backend.dao.repository.EmailRepository;
import br.com.bruno.gs3.clientes.brunogs3backend.dao.repository.TelefoneRepository;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.ClienteDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.EmailDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.TelefoneDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.mapper.EmailMapper;
import br.com.bruno.gs3.clientes.brunogs3backend.mapper.TelefoneMapper;
import br.com.bruno.gs3.clientes.brunogs3backend.service.ServiceGlobal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TelefoneService implements ServiceGlobal<TelefoneDTO> {

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Override
    public List<TelefoneDTO> findAll() {
        return null;
    }

    @Override
    public TelefoneDTO getOne(String id) throws Exception {
        return null;
    }

    @Override
    public TelefoneDTO update(String id, TelefoneDTO dto) throws NotFoundException {
        return null;
    }

    @Override
    public TelefoneDTO create(TelefoneDTO dto) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<TelefoneDTO> addAll(List<TelefoneDTO> listDTO) {
        return new TelefoneMapper().listEntityToDTO(telefoneRepository.saveAll(new TelefoneMapper().listDtoToEntity(listDTO)));
    }


}
