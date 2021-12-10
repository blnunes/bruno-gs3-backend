package br.com.bruno.gs3.clientes.brunogs3backend.dao.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Endereco extends EntityGlobal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_endereco", nullable = false)
    private Long id;

    @Column()
    private String cep;

    @Column()
    private String cidade;

    @Column()
    private String bairro;

    @Column()
    private String logradouro;

    @Column()
    private String complemento;

    @Column()
    private String uf;

}
