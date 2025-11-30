package br.com.tarefas.repository;

import br.com.tarefas.model.Tarefa;
import br.com.tarefas.model.TarefaCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//spring data
public interface TarefaCategoriaRepository extends JpaRepository<TarefaCategoria, Integer> {

    //filtrar todas as tarefas que possui descrição
    public List<TarefaCategoria> findByNome (String nome);
}
