package br.com.tarefas.repository;

import br.com.tarefas.model.Tarefa;
import br.com.tarefas.model.TarefaCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//spring data
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

    //consultas query's

    //filtrar todas as tarefas que possui descrição
    public List<Tarefa> findByDescricao(String descricao);

    //filtrar todas as tarefas que possui determinada descrição
    public List<Tarefa> findByDescricaoLike(String descricao);

    //filtrar tarefa por nome de categoria
    public List<Tarefa> findByCategoria(TarefaCategoria categoria);

    //filtrar por nome de categoria direto
    @Query("select t from Tarefa t inner join t.categoria c where c.nome = ?1")
    public List<Tarefa> findByNomeCategoria(String nomeCategoria);

    public List<Tarefa> tarefasPorCategoria(String nomeCategoria);




}
