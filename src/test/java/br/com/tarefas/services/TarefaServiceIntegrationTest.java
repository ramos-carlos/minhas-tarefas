package br.com.tarefas.services;

import br.com.tarefas.exception.TarefaStatusException;
import br.com.tarefas.model.Tarefa;
import br.com.tarefas.model.TarefaStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TarefaServiceIntegrationTest {

    @Autowired
    private TarefaService service;

    @Test
    void deveIniciarTarefa() {
        Tarefa tarefa = service.iniciarTarefaPorId(2);
        Assertions.assertEquals(TarefaStatus.EM_ANDAMENTO, tarefa.getStatus());
    }

    @Test
    void naoDeveIniciarTarefaConcluida() {
        Tarefa tarefa = service.getTarefaPorId(2);
        tarefa.setStatus(TarefaStatus.CONCLUIDA);
        service.salvarTarefa(tarefa);

        tarefa = service.iniciarTarefaPorId(2);
        Assertions.assertThrows(TarefaStatusException.class,
                () -> service.iniciarTarefaPorId(2));
    }
}
