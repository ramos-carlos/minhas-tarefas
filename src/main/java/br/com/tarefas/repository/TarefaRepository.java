package br.com.tarefas.repository;

import br.com.tarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

//spring data
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
}
