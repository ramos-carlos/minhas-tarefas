package br.com.tarefas.controller;

import br.com.tarefas.controller.assembler.TarefaCategoriaAssembler;
import br.com.tarefas.controller.request.TarefaCategoriaRequest;
import br.com.tarefas.controller.response.TarefaCategoriaResponse;
import br.com.tarefas.model.TarefaCategoria;
import br.com.tarefas.services.TarefaCategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

//responsável em lidar com requisições do servidor
@RestController
public class TarefaCategoriaController {

    //injetando TarefaCategoriaRepository
    @Autowired
    //private TarefaCategoriaRepository repositorio;
    private TarefaCategoriaService service;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TarefaCategoriaAssembler assembler;

    //métodos de operação de crud básico
    @GetMapping("/categoria")//vai expor o metodo para um end-point
    public CollectionModel<EntityModel<TarefaCategoriaResponse>> todasTarefaCategorias() {

        List<TarefaCategoria> categorias = service.getTodasCategorias();

        List<EntityModel<TarefaCategoriaResponse>> categoriasModel = categorias
                .stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(categoriasModel);
    }


    //metodo para recuperar uma tarefa especifica
    @GetMapping("/categoria/{id}")
    public EntityModel<TarefaCategoriaResponse> umaTarefaCategoria(@PathVariable Integer id) {//para recuperar o id

        TarefaCategoria categoria = service.getCategoriaPorId(id);

        return assembler.toModel(categoria);
    }

    //metodo salvar uma tarefa
    @PostMapping("/categoria")
    public ResponseEntity<EntityModel<TarefaCategoriaResponse>>salvarCategoria(@RequestBody TarefaCategoriaRequest categoriaReq) {
        TarefaCategoria categoria = mapper.map(categoriaReq, TarefaCategoria.class);
        EntityModel<TarefaCategoriaResponse> categoriaModel = assembler.toModel(service.salvar(categoria));
        return ResponseEntity
                .created(categoriaModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(categoriaModel);
    }

    //metodo de deletar uma tarefa
    @DeleteMapping("/categoria/{id}")
    public void excluirTarefa(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
