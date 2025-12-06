package br.com.tarefas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

//transformando classe em entidade
@Entity
//alterar propriedades da tabela
@Table(name = "tarefas")
@NamedQuery(name = "Tarefa.tarefasPorCategoria", query = "select t from Tarefa t inner join t.categoria c where c.nome = ?1")
public class Tarefa {

    //entidade Jpa precisa ter um id
    @Id
    //forma de geração do id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //indica que o campo não pode estar vazio
    @NotBlank(message = "{tarefa.descricao.not-black}")
    //quantidade permitida para esse campo
    @Size(min = 5, max = 150, message = "{tarefa.descricao.size}")
    //atributos
    //alterando propriedades das colunas
    @Column(name = "ds_tarefa", nullable = false, length = 150)
    private String descricao;

    //enum
    @Enumerated(EnumType.STRING)
    private TarefaStatus status = TarefaStatus.ABERTO;

    //data presente ou futura
    @FutureOrPresent(message = "{tarefa.descricao.future-or-present}")
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
