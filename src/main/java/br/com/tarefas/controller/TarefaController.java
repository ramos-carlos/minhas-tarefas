package br.com.tarefas.controller;

import br.com.tarefas.model.Tarefa;
import br.com.tarefas.repository.TarefaRepository;
import br.com.tarefas.services.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//responsável em lidar com requisições do servidor
@RestController
public class TarefaController {

    //injetando TarefaRepository
    @Autowired
    //private TarefaRepository repositorio;
    private TarefaService service;

    //métodos de operação de crud básico
    @GetMapping("/tarefa")//vai expor o metodo para um end-point
    public List<Tarefa> todasTarefas(@RequestParam Map<String, String> parametros) {
        if (parametros.isEmpty())
            return service.getTodasTarefas();

        String descricao = parametros.get("descricao");
        return service.getTarefasPorDescricao("%" + descricao + "%");
    }

    //metodo para recuperar uma tarefa especifica
    @GetMapping("/tarefa/{id}")
    public Tarefa umaTarefa(@PathVariable Integer id) {//para recuperar o id
        return service.getTarefaPorId(id);
    }

    //metodo salvar uma tarefa
    @PostMapping("/tarefa")
    public Tarefa salvarTarefa(@Valid @RequestBody Tarefa tarefa) {
        return service.salvarTarefa(tarefa);
    }

    //metodo de deletar uma tarefa
    @DeleteMapping("/tarefa/{id}")
    public void excluirTarefa(@PathVariable Integer id) { //para recuperar o id
        service.deleteById(id);
    }
}
