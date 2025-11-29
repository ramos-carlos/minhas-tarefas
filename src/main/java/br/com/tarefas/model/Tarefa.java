package br.com.tarefas.model;

import jakarta.persistence.*;

import java.time.LocalDate;

//transformando classe em entidade
@Entity
//alterar propriedades da tabela
@Table(name = "tarefas")
public class Tarefa {

    //entidade Jpa precisa ter um id
    @Id
    //forma de geração do id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //atributos
    //alterando propriedades das colunas
    @Column(name = "ds_tarefa", nullable = false, length = 150)
    private String descricao;

    @Enumerated(EnumType.STRING)
    //enum
    private TarefaStatus status;

    private LocalDate dataEntrega;

    private boolean visivel;

    //associação com TarefaCategoria/relacionando com entidade
    @ManyToOne
    //adicionando configurações
    @JoinColumn(nullable = false)
    private TarefaCategoria categoria;

    //associação com Usuário/relacionando com entidade
    @ManyToOne
    //adicionando configurações
    @JoinColumn(nullable = false)
    private Usuario usuario;

    //métodos assessores, getters e setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TarefaStatus getStatus() {
        return status;
    }

    public void setStatus(TarefaStatus status) {
        this.status = status;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public boolean isVisivel() {
        return visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }

    public TarefaCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(TarefaCategoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
