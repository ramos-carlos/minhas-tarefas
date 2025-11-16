package br.com.facint.repository;

import br.com.facint.model.TarefaCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.facint.model.Tarefa;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

    public List<Tarefa> findByDescricao(String descricao);

    //filtrar por palavra
    public List<Tarefa> findByDescricaoLike(String descricao);

    //filtrar nome de categoria
    public List<Tarefa> findByCategoria(TarefaCategoria categoria);

    @Query("select t from Tarefa t inner join t.categoria c where c.nome = ?1")
    public List<Tarefa> findByNomeCategoria(String nomeCategoria);

    public List<Tarefa> tarefasPorCategoria(String nomeCategoria);




}
