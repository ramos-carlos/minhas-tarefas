package br.com.tarefas.services;

import br.com.tarefas.model.Tarefa;
import br.com.tarefas.repository.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//regra de negócio

@Service
public class TarefaService {

    //injetando TarefaRepository
    @Autowired
    private TarefaRepository repositorio;

    //métodos de operação de crud básico

    public List<Tarefa> getTodasTarefas() {
        return repositorio.findAll();
    }

    public List<Tarefa> getTarefasPorDescricao(String descricao) {
        return repositorio.findByDescricaoLike("%" + descricao + "%");
    }

    //metodo para recuperar uma tarefa especifica
    public Tarefa getTarefaPorId(Integer id) {
        return repositorio.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    //metodo salvar uma tarefa
    public Tarefa salvarTarefa (Tarefa tarefa) {
        return repositorio.save(tarefa);
    }

    //metodo de deletar uma tarefa
    public void deleteById (Integer id) {
        repositorio.deleteById(id);
    }
}
