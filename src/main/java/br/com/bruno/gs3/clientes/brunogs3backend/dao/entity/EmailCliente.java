package br.com.bruno.gs3.clientes.brunogs3backend.dao.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailCliente extends EntityGlobal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_email", nullable = false)
    private Long id;

    @Email
    private String email;

    @ManyToOne()
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailCliente that = (EmailCliente) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }




}
