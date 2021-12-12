package br.com.bruno.gs3.clientes.brunogs3backend.dto;

import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.Cliente;
import br.com.bruno.gs3.clientes.brunogs3backend.enums.TipoTelefoneEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelefoneDTO extends DTO{
    private Long id;
    private TipoTelefoneEnum tipoTelefone;
    private String ddd;
    private String numero;
    private ClienteDTO clienteDTO;
}
