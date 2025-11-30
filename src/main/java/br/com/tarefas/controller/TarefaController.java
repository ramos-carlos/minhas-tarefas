package br.com.tarefas.controller;

import br.com.tarefas.model.Tarefa;
import br.com.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//responsável em lidar com requisições do servidor
@RestController
public class TarefaController {

    //injetando TarefaRepository
    @Autowired
    private TarefaRepository repositorio;

    //métodos de operação de crud básico
    @GetMapping("/tarefa")//vai expor o metodo para um end-point
    public List<Tarefa> todasTarefas(@RequestParam Map<String, String> parametros) {
        if (parametros.isEmpty())
            return repositorio.findAll();

        String descricao = parametros.get("descricao");
        return repositorio.findByDescricaoLike("%" + descricao + "%");
    }

    //metodo para recuperar uma tarefa especifica
    @GetMapping("/tarefa/{id}")
    public Tarefa umaTarefa(@PathVariable Integer id) { //para recuperar o id
        return repositorio.findById(id).orElse(null);
    }

    //metodo salvar uma tarefa
    @PostMapping("/tarefa")
    public Tarefa salvarTarefa(@RequestBody Tarefa tarefa) {
        return repositorio.save(tarefa);
    }

    //metodo de deletar uma tarefa
    @DeleteMapping("/tarefa/{id}")
    public void excluirTarefa(@PathVariable Integer id) { //para recuperar o id
        repositorio.deleteById(id);
    }





}
