package br.com.tarefas.model;

public class Usuario {

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
}
