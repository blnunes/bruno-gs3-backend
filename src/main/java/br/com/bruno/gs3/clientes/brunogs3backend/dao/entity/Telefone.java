package br.com.bruno.gs3.clientes.brunogs3backend.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Telefone extends EntityGlobal{
    @Id
    @Column(name = "id_telefone", nullable = false)
    private Long id_telefone;

    @Column()
    private String ddd;

    @Column()
    private String numero;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return id_telefone.equals(telefone.id_telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_telefone);
    }
}
