package br.com.animati.gestao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idatividade;

    @JoinColumn(name = "projeto_id", nullable = false)
    @OneToOne
    private Projeto projeto;

    @JoinColumn(name = "responsavel_id", nullable = false)
    @OneToOne
    private Responsavel responsavel;

    private String task;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;
}
