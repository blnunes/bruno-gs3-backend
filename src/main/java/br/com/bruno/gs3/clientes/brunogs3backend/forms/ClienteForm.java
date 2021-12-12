package br.com.bruno.gs3.clientes.brunogs3backend.forms;

import br.com.bruno.gs3.clientes.brunogs3backend.dto.ClienteDTO;
import br.com.bruno.gs3.clientes.brunogs3backend.dto.DTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteForm extends FormGlobal {
    private Long idCliente;
    private String nome;
    private String cpf;
    private EnderecoForm endereco;
    private List<EmailForm> emails;
    private List<TelefoneForm> telefones;
}
