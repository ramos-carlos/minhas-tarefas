package br.com.tarefas.repository;

import br.com.tarefas.model.Tarefa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TarefaRepositoryTest {

    @Autowired
    private TarefaRepository repositorio;

    @Test
    void testFindByNomeCategoria() {
        List<Tarefa> tarefas = repositorio.findByNomeCategoria("Estudos");
        //verificar se vai retornar as duas tarefas dessa categoria
        Assertions.assertEquals(2, tarefas.size());

    }

    @Test
    void testTarefasPorCategoria() {
        List<Tarefa> tarefas = repositorio.tarefasPorCategoria("Estudos");
        //verificar se vai retornar as duas tarefas dessa categoria
        Assertions.assertEquals(2, tarefas.size());

    }

}
