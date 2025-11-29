package br.com.tarefas.model;

import jakarta.persistence.*;

//transformando classe em entidade
@Entity
@Table(name = "usuarios")
public class Usuario {

    //entidade Jpa precisa ter um id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //atributos
    private String nome;

    private String senha;

    //métodos assessores, getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
