package br.com.bruno.gs3.clientes.brunogs3backend.dao.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoricoTransacao {
    @Id
    @Column(name = "id_transacao", nullable = false)
    private Long id_transacao;

    @Column()
    private LocalDateTime data;

    @Column()
    private String usuario;

}
