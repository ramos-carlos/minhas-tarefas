package br.com.tarefas.controller;

import br.com.tarefas.model.TarefaCategoria;
import br.com.tarefas.repository.TarefaCategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//responsável em lidar com requisições do servidor
@RestController
public class TarefaCategoriaController {

    //injetando TarefaCategoriaRepository
    @Autowired
    private TarefaCategoriaRepository repositorio;

    //métodos de operação de crud básico
    @GetMapping("/categoria")//vai expor o metodo para um end-point
    public List<TarefaCategoria> todasTarefaCategorias(@RequestParam Map<String, String> parametros) {
        if (parametros.isEmpty())
            return repositorio.findAll();

        String descricaoCategoria = parametros.get("descricaoCategoria");
        return repositorio.findByNome(descricaoCategoria);
    }

    //metodo para recuperar uma tarefa especifica
    @GetMapping("/categoria/{id}")
    public TarefaCategoria umaTarefaCategoria(@PathVariable Integer id) {//para recuperar o id
        return repositorio.findById(id).orElse(null);
    }

    //metodo salvar uma tarefa
    @PostMapping("/categoria")
    public TarefaCategoria salvarCategoria(@Valid @RequestBody TarefaCategoria tarefaCategoria) {
        return repositorio.save(tarefaCategoria);
    }

    //metodo de deletar uma tarefa
    @DeleteMapping("/categoria/{id}")
    public void excluirCategoria(@PathVariable Integer id) {
        repositorio.deleteById(id);
    }
}
