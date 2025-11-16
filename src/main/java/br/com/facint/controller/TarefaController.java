package br.com.facint.controller;

import br.com.facint.model.Tarefa;
import br.com.facint.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TarefaController {

    @Autowired
    private TarefaRepository repositorio;

    @GetMapping("/tarefa")
    public List<Tarefa> todasTarefas(@RequestParam Map<String, String> parametros) {
        if (parametros.isEmpty()) {
            return repositorio.findAll();
        } else {
            String descricao = parametros.get("descricao");
            return repositorio.findByDescricaoLike("%" + descricao + "%");
        }
    }

    @GetMapping("/tarefa/{id}")
    public Tarefa umaTarefa(@PathVariable Integer id) {
        return repositorio.findById(id).orElse(null);
    }

    @PostMapping("/tarefa")
    public Tarefa salvarTarefa(@RequestBody Tarefa salvar) {
        return repositorio.save(salvar);
    }

    @DeleteMapping("/tarefa/{id}")
    public void excluirTarefa(@PathVariable Integer id) {
        repositorio.deleteById(id);
    }


}
