package br.com.bruno.gs3.clientes.brunogs3backend.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO extends DTO{

    private Long id;

    @Size(min = 3, max = 100, message = "Campo nome deve ter no mínimo 3 e no máximo 100 caracteres")
    private String nome;

    @Size(min = 11, max=11, message = "Campo CPF deve ter o tamanho igual a 11")
    private String cpf;

    @Valid
    private EnderecoDTO endereco;

    @Valid
    private List<EmailDTO> emails;

    @Valid
    private List<TelefoneDTO> telefones;
}
