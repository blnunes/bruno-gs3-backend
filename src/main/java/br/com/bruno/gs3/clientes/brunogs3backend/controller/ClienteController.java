package br.com.bruno.gs3.clientes.brunogs3backend.controller;

import br.com.bruno.gs3.clientes.brunogs3backend.dto.ClienteDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.EmailDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.EnderecoDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.TelefoneDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.enums.TipoTelefoneEnum;
import br.com.bruno.gs3.clientes.brunogs3backend.service.impl.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping()
    public ResponseEntity<List<ClienteDTO>> list(){
        ArrayList<ClienteDTO> clientes = new ArrayList<>();
        clientes.add(ClienteDTO.builder().cpf("03528843128")
                .id(1L)
                .emails(preencheEmail())
                .enderecoDTO(EnderecoDTO.builder().id(1L)
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

    private Set<EmailDTO> preencheEmail() {
        HashSet<EmailDTO> emails = new HashSet<>();
        emails.add(EmailDTO.builder().email("brunoln91@gmail.com")
                .id(1L)
                .build());
        return emails;
    }

    private Set<TelefoneDTO> preencheTelefone() {
        HashSet<TelefoneDTO> telefones = new HashSet<>();
        telefones.add(
        TelefoneDTO.builder().tipoTelefone(TipoTelefoneEnum.CELULAR)
                .id(1L)
                .ddd("61")
                .numero("991871010").build());
        return telefones;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO clienteDTO){
        return new ResponseEntity<>(clienteService.create(clienteDTO), HttpStatus.CREATED);
    }

}
