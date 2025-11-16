package br.com.facint.tarefas.repository;

import br.com.facint.model.Tarefa;
import br.com.facint.repository.TarefaRepository;
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
    void testFindByNomeCategoria(){
        List<Tarefa> tarefas = repositorio.findByNomeCategoria("Estudos");
        Assertions.assertEquals(2, tarefas.size());
    }

    @Test
    void testTarefasPorCategoria(){
        List<Tarefa> tarefas = repositorio.findByNomeCategoria("Estudos");
        Assertions.assertEquals(2, tarefas.size());
    }
}

