package br.com.bruno.gs3.clientes.brunogs3backend.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailDTO extends DTO{
    private Long id;
    private String email;
}
