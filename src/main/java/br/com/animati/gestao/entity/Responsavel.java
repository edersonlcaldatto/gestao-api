package br.com.animati.gestao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idresponsavel;

    private String nome;

    @Enumerated(EnumType.STRING)
    private FuncaoEnum funcao;

}
