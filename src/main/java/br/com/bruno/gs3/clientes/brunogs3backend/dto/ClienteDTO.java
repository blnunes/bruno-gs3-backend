package br.com.bruno.gs3.clientes.brunogs3backend.dto;

import lombok.*;

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
    private String cpf;
    private EnderecoDTO endereco;
    private List<EmailDTO> emails;
    private List<TelefoneDTO> telefones;
}
