package br.com.tarefas.controller.assembler;

import br.com.tarefas.controller.UsuarioController;
import br.com.tarefas.controller.response.UsuarioResponse;
import br.com.tarefas.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UsuarioModelAssembler
implements RepresentationModelAssembler<Usuario, EntityModel<UsuarioResponse>> {

    @Autowired
    private ModelMapper mapper;

    @Override
    public EntityModel<UsuarioResponse> toModel(Usuario usuario) {

        UsuarioResponse response = mapper.map(usuario, UsuarioResponse.class);

        return EntityModel.of(response,

                linkTo(methodOn(UsuarioController.class)
                        .umUsuario(response.getId())).withSelfRel()
        );
    }
}
