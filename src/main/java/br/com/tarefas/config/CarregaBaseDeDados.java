package br.com.tarefas.config;

import br.com.tarefas.model.Tarefa;
import br.com.tarefas.model.TarefaCategoria;
import br.com.tarefas.model.TarefaStatus;
import br.com.tarefas.model.Usuario;
import br.com.tarefas.repository.TarefaCategoriaRepository;
import br.com.tarefas.repository.TarefaRepository;
import br.com.tarefas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

//quando se trata de classe de configuração
@Configuration
@Profile("dev")//mesmo perfil definido no properties
public class CarregaBaseDeDados {

    //injetando o Repository, e gerando persistência dos objetos dentro do executar
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TarefaCategoriaRepository categoriaRepository;

    @Autowired
    private TarefaRepository tarefaRepository;

    //a aplicação executa quando o código tiver dentro desse metodo
    @Bean
    CommandLineRunner executar() {
        return args -> {
            Usuario usuario = new Usuario();
            usuario.setNome("Admin");
            usuario.setSenha("123456");
            //salvar o registro no banco de dados
            usuarioRepository.save(usuario);

            TarefaCategoria categoria = new TarefaCategoria();
            categoria.setNome("Estudos");
            //salvar o registro no banco de dados
            categoriaRepository.save(categoria);

            Tarefa tarefa = new Tarefa();
            tarefa.setDescricao("Spring Boot");
            tarefa.setDataEntrega(LocalDate.now().plusDays(1));
            tarefa.setStatus(TarefaStatus.ABERTO);
            tarefa.setVisivel(true);
            tarefa.setCategoria(categoria);
            tarefa.setUsuario(usuario);
            //salvar o registro no banco de dados
            tarefaRepository.save(tarefa);
        };
    }
}
