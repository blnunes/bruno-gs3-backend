package br.com.bruno.gs3.clientes.brunogs3backend.controller;

import br.com.bruno.gs3.clientes.brunogs3backend.dto.ClienteDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.EmailDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.EnderecoDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.TelefoneDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.enums.TipoTelefoneEnum;
import br.com.bruno.gs3.clientes.brunogs3backend.forms.ClienteForm;
import br.com.bruno.gs3.clientes.brunogs3backend.mapper.ClienteMapper;
import br.com.bruno.gs3.clientes.brunogs3backend.service.impl.ClienteService;
import br.com.bruno.gs3.clientes.brunogs3backend.service.impl.EmailService;
import br.com.bruno.gs3.clientes.brunogs3backend.service.impl.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private TelefoneService telefoneService;

    @GetMapping()
    public ResponseEntity<List<ClienteDTO>> list() {
        ArrayList<ClienteDTO> clientes = new ArrayList<>();
        clientes.add(ClienteDTO.builder().cpf("03528843128")
                .id(1L)
                .emails(preencheEmail())
                .endereco(EnderecoDTO.builder().id(1L)
                        .cep("72115145")
                        .bairro("Taguatinga")
                        .cidade("Brasília")
                        .logradouro("Quadra")
                        .complemento("Apto 706").build())
                .telefones(preencheTelefone())
                .nome("Bruno Lima Nunes")
                .build());
        return ResponseEntity.ok(clientes);
    }

    private List<EmailDTO> preencheEmail() {
        List<EmailDTO> emails = new ArrayList<>();
        emails.add(EmailDTO.builder().email("brunoln91@gmail.com")
                .id(1L)
                .build());
        return emails;
    }

    private List<TelefoneDTO> preencheTelefone() {
        List<TelefoneDTO> telefones = new ArrayList<>();
        telefones.add(
                TelefoneDTO.builder().tipoTelefone(TipoTelefoneEnum.CELULAR)
                        .id(1L)
                        .ddd("61")
                        .numero("991871010").build());
        return telefones;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteForm> create(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO retornoCliente = clienteService.create(clienteDTO);
        List<TelefoneDTO> retornoListaTelefone = telefoneService.addAll(preencheListaTelefone(clienteDTO.getTelefones(), retornoCliente));
        List<EmailDTO> retornoListaEmail = emailService.addAll(preencheListaEmail(clienteDTO.getEmails(), retornoCliente));

        return new ResponseEntity<>(montaObjetoRetorno(retornoCliente, retornoListaTelefone, retornoListaEmail), HttpStatus.CREATED);
    }

    @PutMapping("/alterar/{id}")
    @Transactional
    public ResponseEntity<ClienteForm> update(@PathVariable String id, @RequestBody ClienteDTO clienteDTO) throws NotFoundException {
        ClienteDTO retornoCliente = clienteService.update(id, clienteDTO);
        List<TelefoneDTO> retornoListaTelefone = telefoneService.addAll(preencheListaTelefone(clienteDTO.getTelefones(), retornoCliente));
        List<EmailDTO> retornoListaEmail = emailService.addAll(preencheListaEmail(clienteDTO.getEmails(), retornoCliente));
        return new ResponseEntity<>(montaObjetoRetorno(retornoCliente, retornoListaTelefone, retornoListaEmail), HttpStatus.NO_CONTENT);

    }

    private ClienteForm montaObjetoRetorno(ClienteDTO retornoCliente, List<TelefoneDTO> retornoListaTelefone, List<EmailDTO> retornoListaEmail) {
        retornoCliente.setTelefones(retornoListaTelefone);
        retornoCliente.setEmails(retornoListaEmail);
        return new ClienteMapper().dtoToForm(retornoCliente);
    }

    private List<TelefoneDTO> preencheListaTelefone(List<TelefoneDTO> telefoneDTOList, ClienteDTO retornoCliente) {
        return telefoneDTOList.stream().map(telefoneDTO -> {
            telefoneDTO.setClienteDTO(retornoCliente);
            return telefoneDTO;
        }).collect(Collectors.toList());
    }

    private List<EmailDTO> preencheListaEmail(List<EmailDTO> emailDTOList, ClienteDTO retornoCliente) {
        return emailDTOList.stream().map(telefoneDTO -> {
            telefoneDTO.setClienteDTO(retornoCliente);
            return telefoneDTO;
        }).collect(Collectors.toList());
    }

}
