package br.com.tarefas.repository;

import br.com.tarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//spring data
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

    //query's
    //recupera todas as tarefas que possui determinada descrição

    public List<Tarefa> findByDescricao(String descricao);

    public List<Tarefa> findByDescricaoLike(String descricao);


}
