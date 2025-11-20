package br.com.facint.services;

import br.com.facint.model.Tarefa;
import br.com.facint.repository.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repositorio;

    //mapeando os metodos do TarefaController

    public List<Tarefa> getTodasTarefas() {
        return repositorio.findAll();
    }

    public List<Tarefa> getTarefasPorDescricao(String descricao) {
        return repositorio.findByDescricaoLike("%" + descricao + "%");
    }

    public Tarefa getTarefaPorId (Integer id) {
        return repositorio.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    public Tarefa salvarTarefa (Tarefa tarefa) {
        return repositorio.save(tarefa);
    }

    public void deleteById (Integer id) {
        repositorio.deleteById(id);
    }
}
