package br.com.bruno.gs3.clientes.brunogs3backend.dto;

import br.com.bruno.gs3.clientes.brunogs3backend.enums.TipoTelefoneEnum;
import br.com.bruno.gs3.clientes.brunogs3backend.validation.ValidadorTelefone;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ValidadorTelefone
public class TelefoneDTO extends DTO{

    private Long id;

    @NotNull(message = "Tipo telefone não pode ser nulo")
    private TipoTelefoneEnum tipoTelefone;

    @Size(min = 2, max = 2, message = "Campo ddd deve conter apenas 2 digitos. Exemplo: 99")
    private String ddd;
    private String numero;
    private ClienteDTO clienteDTO;
}
