package br.com.facint.controller;

import br.com.facint.model.Tarefa;
import br.com.facint.services.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TarefaController {

    @Autowired
    private TarefaService service;

    @GetMapping("/tarefa")
    public List<Tarefa> todasTarefas(@RequestParam Map<String, String> parametros) {
        if (parametros.isEmpty()) {
            return service.getTodasTarefas();
        } else {
            String descricao = parametros.get("descricao");
            return service.getTarefasPorDescricao(descricao);
        }
    }

    @GetMapping("/tarefa/{id}")
    public Tarefa umaTarefa(@PathVariable Integer id) {
        return service.getTarefaPorId(id);
    }

    @PostMapping("/tarefa")
    public Tarefa salvarTarefa(@Valid @RequestBody Tarefa tarefa) {
        return service.salvarTarefa(tarefa);
    }

    @DeleteMapping("/tarefa/{id}")
    public void excluirTarefa(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
