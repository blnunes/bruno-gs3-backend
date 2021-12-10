package br.com.bruno.gs3.clientes.brunogs3backend.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO extends DTO{
    private Long id;
    private String nome;
    private String cpf;
    private EnderecoDTO enderecoDTO;
    private Set<EmailDTO> emails;
    private Set<TelefoneDTO> telefones;
}
