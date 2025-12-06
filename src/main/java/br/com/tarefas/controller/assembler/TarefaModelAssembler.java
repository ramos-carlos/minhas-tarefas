package br.com.tarefas.controller.assembler;

import br.com.tarefas.controller.TarefaCategoriaController;
import br.com.tarefas.controller.TarefaController;
import br.com.tarefas.controller.UsuarioController;
import br.com.tarefas.controller.response.TarefaResponse;
import br.com.tarefas.model.Tarefa;
import br.com.tarefas.model.TarefaStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.HashMap;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TarefaModelAssembler
implements RepresentationModelAssembler<Tarefa, EntityModel<TarefaResponse>> {

    @Autowired
    private ModelMapper mapper;

    @Override
    public EntityModel<TarefaResponse> toModel(Tarefa tarefa) {
        TarefaResponse tarefaResp = mapper.map(tarefa, TarefaResponse.class);

        EntityModel<TarefaResponse> tarefaModel = EntityModel.of(tarefaResp,
                linkTo(methodOn(TarefaController.class).umaTarefa(tarefaResp.getId())).withSelfRel(),
                linkTo(methodOn(TarefaController.class).todasTarefas(new HashMap<>())).withRel("tarefas"),
                linkTo(methodOn(TarefaCategoriaController.class).umaTarefaCategoria(tarefaResp.getCategoriaId())).withRel("categoria"),
                linkTo(methodOn(UsuarioController.class).umUsuario(tarefaResp.getUsuarioId())).withRel("usuario"));

        if (TarefaStatus.EM_ANDAMENTO.equals(tarefa.getStatus())) {
            tarefaModel.add(
                    linkTo(methodOn(TarefaController.class).concluirTarefa(tarefa.getId())).withRel("conlcuir"),
                    linkTo(methodOn(TarefaController.class).cancelarTarefa(tarefa.getId())).withRel("cancelar")
            );
        }

        if (TarefaStatus.ABERTO.equals(tarefa.getStatus())) {
            tarefaModel.add(
                    linkTo(methodOn(TarefaController.class).iniciarTarefa(tarefa.getId())).withRel("iniciar")
            );
        }

        return tarefaModel;
    }
}
