package br.com.bruno.gs3.clientes.brunogs3backend.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO extends DTO{
    private Long id;
    private String nome;
    private String cpf;
    private EnderecoDTO endereco;
    private List<EmailDTO> emails;
    private List<TelefoneDTO> telefones;
}
