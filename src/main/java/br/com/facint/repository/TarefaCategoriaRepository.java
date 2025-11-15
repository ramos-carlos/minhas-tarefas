package br.com.facint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.facint.model.Tarefa;
import br.com.facint.model.TarefaCategoria;

public interface TarefaCategoriaRepository extends JpaRepository<TarefaCategoria, Integer> {

}
