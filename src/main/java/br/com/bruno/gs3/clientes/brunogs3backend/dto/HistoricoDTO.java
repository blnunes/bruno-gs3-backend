package br.com.bruno.gs3.clientes.brunogs3backend.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoricoDTO {
    private LocalDateTime date;
    private String usuario;
}
