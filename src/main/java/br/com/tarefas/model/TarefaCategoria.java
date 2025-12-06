package br.com.tarefas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

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

    @NotBlank(message = "{tarefa.descricao.not-blank}")
    @Size(min = 5, max = 50, message = "Campo nome deve ter entre 5 e 50 letras")
    @Column(length = 50)
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
