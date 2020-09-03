package br.com.pi.projeto_RD.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "TB_OPERADOR")
@Data
public class OperadorEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_OPERADOR")
    private BigInteger idOperador;

    @Column(name = "NM_NOME")
    private String nmOperador;

    @Column(name = "NR_CPF")
    private String nrCpf;

    @Column(name = "NR_MATRICULA")
    private BigInteger nrMatricula;

    @Column(name = "DS_CARGO")
    private String dsCargo;

    @Column(name = "CD_FILIAL")
    private BigInteger cdFilial;

    @Column(name = "PW_OPERADOR")
    private String pwOperador;

    @ManyToMany
    @JoinTable(name = "TB_OPERADOR_PERFIL",
            joinColumns = @JoinColumn(name = "ID_OPERADOR"),
            inverseJoinColumns = @JoinColumn(name = "ID_PERFIL")
    )
    private List<PerfilEntity> perfil;


}
