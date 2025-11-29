package br.com.tarefas.model;

import jakarta.persistence.*;

//transformando classe em entidade
@Entity
@Table(name = "tarefas_categoria")
public class TarefaCategoria {

    //entidade Jpa precisa ter um id
    @Id
    //forma de geração do id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //atributos
    private String nome;

    //métodos assessores, getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
