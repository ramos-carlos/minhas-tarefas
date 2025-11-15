package br.com.facint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.facint.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

}
