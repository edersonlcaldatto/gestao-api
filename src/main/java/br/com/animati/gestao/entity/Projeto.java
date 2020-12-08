package br.com.animati.gestao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idprojeto;
    private String nome;

    @JoinColumn(name = "cliente_id", nullable = false)
    @OneToOne
    private Cliente cliente;

    private String descricao;
}
