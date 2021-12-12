package br.com.bruno.gs3.clientes.brunogs3backend.forms;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailForm extends FormGlobal {
    private Long id;
    private String email;
}
