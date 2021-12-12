package br.com.bruno.gs3.clientes.brunogs3backend.controller;

import br.com.bruno.gs3.clientes.brunogs3backend.dto.ClienteDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.EmailDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.EnderecoDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.TelefoneDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.enums.TipoTelefoneEnum;
import br.com.bruno.gs3.clientes.brunogs3backend.forms.ClienteForm;
import br.com.bruno.gs3.clientes.brunogs3backend.mapper.ClienteMapper;
import br.com.bruno.gs3.clientes.brunogs3backend.service.impl.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


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
    public ResponseEntity<ClienteForm> create(@Valid @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO retornoCliente = clienteService.create(clienteDTO);
        return new ResponseEntity<>(new ClienteMapper().dtoToForm(retornoCliente), HttpStatus.CREATED);
    }

    @PutMapping("/alterar/{id}")
    @Transactional
    public ResponseEntity<ClienteForm> update(@PathVariable String id, @Valid @RequestBody ClienteDTO clienteDTO) throws NotFoundException {
        ClienteDTO retornoCliente = clienteService.update(id, clienteDTO);
        return new ResponseEntity<>(new ClienteMapper().dtoToForm(retornoCliente), HttpStatus.NO_CONTENT);
    }

    private ClienteForm montaObjetoRetorno(ClienteDTO retornoCliente) {
        return new ClienteMapper().dtoToForm(retornoCliente);
    }



}
