package br.com.bruno.gs3.clientes.brunogs3backend.service.impl;

import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.Cliente;
import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.EmailCliente;
import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.Endereco;
import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.Telefone;
import br.com.bruno.gs3.clientes.brunogs3backend.dao.repository.ClienteRepository;
import br.com.bruno.gs3.clientes.brunogs3backend.dao.repository.EmailRepository;
import br.com.bruno.gs3.clientes.brunogs3backend.dao.repository.TelefoneRepository;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.ClienteDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.EmailDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.EnderecoDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.TelefoneDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.mapper.ClienteMapper;
import br.com.bruno.gs3.clientes.brunogs3backend.mapper.EmailMapper;
import br.com.bruno.gs3.clientes.brunogs3backend.mapper.TelefoneMapper;
import br.com.bruno.gs3.clientes.brunogs3backend.service.ServiceGlobal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService implements ServiceGlobal<ClienteDTO> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;


    @Override
    public List<ClienteDTO> findAll() {
        return clienteRepository.findAll().stream().map(cliente ->
                new ClienteMapper().entityToDTO(cliente)
        ).collect(Collectors.toList());
    }

    @Override
    public ClienteDTO getOne(String id) {
        return new ClienteMapper().entityToDTO(clienteRepository.getById(Long.valueOf(id)));
    }

    @Override
    public ClienteDTO update(String id, ClienteDTO dto) throws NotFoundException {
        try {
            Cliente cliente = clienteRepository.getById(Long.valueOf(id));
            return new ClienteMapper().entityToDTO(clienteRepository.save(montaObjetoPersistencia(dto, cliente)));
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("Cliente do não encontrado!");
        }
    }

    public Cliente montaObjetoPersistencia(ClienteDTO dto, Cliente entity) {
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setEmails(montaListaEmail(dto.getEmails(), entity));
        entity.setEndereco(montaEndereco(dto.getEndereco(), entity.getEndereco()));
        entity.setTelefones(montaListaTelefone(dto.getTelefones(), entity));
        return entity;
    }

    private List<Telefone> montaListaTelefone(List<TelefoneDTO> dto, Cliente entity) {
        for (int i = 0; i < dto.size(); i++) {
            if(i >= entity.getTelefones().size() || entity.getTelefones().get(i).getCliente() == null){
                Telefone telefone = new TelefoneMapper().dtoToEntity(dto.get(i));
                telefone.setCliente(entity);
                entity.getTelefones().add(telefone);
            }else {
                entity.getTelefones().get(i).setDdd(dto.get(i).getDdd());
                entity.getTelefones().get(i).setNumero(dto.get(i).getNumero());
            }
        }
        return entity.getTelefones();
    }

    private Endereco montaEndereco(EnderecoDTO dto, Endereco entity) {
        entity.setBairro(dto.getBairro());
        entity.setCep(dto.getCep());
        entity.setCidade(dto.getCidade());
        entity.setComplemento(dto.getComplemento());
        entity.setLogradouro(dto.getLogradouro());
        entity.setUf(dto.getUf());
        return entity;
    }

    private List<EmailCliente> montaListaEmail(List<EmailDTO> dto, Cliente entity) {
        for (int i = 0; i < dto.size(); i++) {
            if(i >= entity.getEmails().size() || entity.getEmails().get(i).getCliente() == null){
                EmailCliente emailCliente = new EmailMapper().dtoToEntity(dto.get(i));
                emailCliente.setCliente(entity);
                entity.getEmails().add(emailCliente);
            }else {
                entity.getEmails().get(i).setEmail(dto.get(i).getEmail());
            }
        }
        return entity.getEmails();
    }

    @Override
    public ClienteDTO create(ClienteDTO dto) {
        try {
            Cliente cliente = clienteRepository.save(new ClienteMapper().dtoToEntity(dto));
            List<Telefone> retornoListaTelefone =
                    telefoneRepository.saveAll(preencheListaTelefone(dto.getTelefones()
                            .stream().map(telefoneDTO -> new TelefoneMapper().dtoToEntity(telefoneDTO)).collect(Collectors.toList()), cliente));
            List<EmailCliente> retornoListaEmail =
                    emailRepository.saveAll(preencheListaEmail(dto.getEmails().stream()
                            .map(emailDTO -> new EmailMapper().dtoToEntity(emailDTO)).collect(Collectors.toList()), cliente));
            cliente.setTelefones(retornoListaTelefone);
            cliente.setEmails(retornoListaEmail);
            return new ClienteMapper().entityToDTO(cliente);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateKeyException("CPF: "+dto.getCpf()+" já cadastrado");
        }
    }

    private List<Telefone> preencheListaTelefone(List<Telefone> telefones, Cliente retornoCliente) {
        return telefones.stream().map(telefone -> {
            telefone.setCliente(retornoCliente);
            return telefone;
        }).collect(Collectors.toList());
    }

    private List<EmailCliente> preencheListaEmail(List<EmailCliente> emails, Cliente retornoCliente) {
        return emails.stream().map(telefoneDTO -> {
            telefoneDTO.setCliente(retornoCliente);
            return telefoneDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        clienteRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public List<ClienteDTO> addAll(List<ClienteDTO> listDTO) {
        return null;
    }

}
