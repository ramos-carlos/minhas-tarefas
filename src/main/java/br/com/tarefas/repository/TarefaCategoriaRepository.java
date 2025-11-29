package br.com.tarefas.repository;

import br.com.tarefas.model.TarefaCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

//spring data
public interface TarefaCategoriaRepository extends JpaRepository<TarefaCategoria, Integer> {
}
