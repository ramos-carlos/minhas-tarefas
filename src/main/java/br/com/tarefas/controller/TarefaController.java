package br.com.tarefas.controller;

import br.com.tarefas.controller.assembler.TarefaModelAssembler;
import br.com.tarefas.controller.request.TarefaRequest;
import br.com.tarefas.model.Tarefa;
import br.com.tarefas.controller.response.TarefaResponse;
import br.com.tarefas.services.TarefaService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

//responsável em lidar com requisições do servidor
@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    //injetando TarefaRepository
    @Autowired
    //private TarefaRepository repositorio;
    private TarefaService service;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TarefaModelAssembler assembler;

    //métodos de operação de crud básico
    @GetMapping
    public CollectionModel<EntityModel<TarefaResponse>> todasTarefas(@RequestParam Map<String, String> parametros) {
        List<Tarefa> tarefas = new ArrayList<>();

        if (parametros.isEmpty()) {
            tarefas = service.getTodasTarefas();
        } else {
            String descricao = parametros.get("descricao");
             tarefas = service.getTarefasPorDescricao("%" + descricao + "%");
        }

        List<EntityModel<TarefaResponse>> tarefasModel = tarefas
                .stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(tarefasModel,
                linkTo(methodOn(TarefaController.class).todasTarefas(new HashMap<>()))
                        .withSelfRel()
        );
    }

    //metodo para recuperar uma tarefa especifica
    //implementando HATEOAS
    @GetMapping("/{id}")
    public EntityModel<TarefaResponse> umaTarefa(@PathVariable Integer id) {//para recuperar o id
        Tarefa tarefa = service.getTarefaPorId(id);
        //implementando DTO
        return assembler.toModel(tarefa);
    }

    //metodo salvar uma tarefa
    @PostMapping
    public ResponseEntity<EntityModel<TarefaResponse>> salvarTarefa(@Valid @RequestBody TarefaRequest tarefaReq) {
        Tarefa tarefa = mapper.map(tarefaReq, Tarefa.class);
        Tarefa tarefaSalva = service.salvarTarefa(tarefa);

        EntityModel<TarefaResponse> tarefaModel = assembler.toModel(tarefaSalva);

        return ResponseEntity.
                created(tarefaModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(tarefaModel);

    }

    //metodo de deletar uma tarefa
    @DeleteMapping("/{id}")
    public void excluirTarefa(@PathVariable Integer id) { //para recuperar o id
        service.deleteById(id);
    }


    @PutMapping("/{id}/iniciar")
    public EntityModel<TarefaResponse> iniciarTarefa(@PathVariable Integer id) {
        Tarefa tarefa = service.iniciarTarefaPorId(id);
        return assembler.toModel(tarefa);
    }

    @PutMapping("/{id}/concluir")
    public EntityModel<TarefaResponse> concluirTarefa(@PathVariable Integer id) {
        Tarefa tarefa = service.concluirTarefaPorId(id);
        return assembler.toModel(tarefa);
    }

    @PutMapping("/{id}/cancelar")
    public EntityModel<TarefaResponse> cancelarTarefa(@PathVariable Integer id) {
        Tarefa tarefa = service.cancelarTarefaPorId(id);
        return assembler.toModel(tarefa);
    }


}
