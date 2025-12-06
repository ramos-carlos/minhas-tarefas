package br.com.tarefas.services;

import br.com.tarefas.model.TarefaCategoria;
import br.com.tarefas.repository.TarefaCategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaCategoriaService {

    @Autowired
    private TarefaCategoriaRepository repository;

    public List<TarefaCategoria> getTodasCategorias() {
        return repository.findAll();
    }

    public TarefaCategoria getCategoriaPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    public TarefaCategoria salvar(TarefaCategoria categoria) {
        return repository.save(categoria);
    }

    public void deleteById(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Categoria não encontrada para exclusão com id: " + id);
        }
        repository.deleteById(id);
    }
}
