package br.com.pi.projeto_RD.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_TIPO_FORNECEDOR")
@Data
public class TipoFornecedorEntity {

    @Id
    @Column(name = "ID_TIPO_FORNECEDOR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_fornecedor;

    @Column(name = "DS_TIPO_FORNECEDOR")
    private String ds_tipo_fornecedor;

    @OneToMany(mappedBy = "fk_tipo_fornecedor", cascade = CascadeType.ALL)
    private List<FornecedorEntity> tipo_fornecedor;

}
