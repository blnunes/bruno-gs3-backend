package br.com.bruno.gs3.clientes.brunogs3backend.dto;


import br.com.bruno.gs3.clientes.brunogs3backend.dao.entity.Cliente;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailDTO extends DTO{
    private Long id;
    private String email;
    private ClienteDTO clienteDTO;
}
