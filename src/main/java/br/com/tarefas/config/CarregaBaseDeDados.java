package br.com.tarefas.config;

import br.com.tarefas.model.*;
import br.com.tarefas.repository.RoleRepository;
import br.com.tarefas.repository.TarefaCategoriaRepository;
import br.com.tarefas.repository.TarefaRepository;
import br.com.tarefas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Set;

//quando se trata de classe de configuração
@Configuration
@Profile("dev")//mesmo perfil definido no properties
public class CarregaBaseDeDados {

    //injetando o Repository, e gerando persistência dos objetos dentro do executar
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TarefaCategoriaRepository categoriaRepository;

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private PasswordEncoder encoder;

    //a aplicação executa quando o código tiver dentro desse metodo
    @Bean
    CommandLineRunner executar() {
        return args -> {

            Role roleAdmin = new Role(ERole.ROLE_ADMIN);
            roleAdmin = roleRepository.save(roleAdmin);

            Usuario usuario = new Usuario();
            usuario.setNome("Admin");

            usuario.setSenha(encoder.encode("123456"));
            usuario.setRoles(Set.of(roleAdmin));

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

            Tarefa tarefa2 = new Tarefa();
            tarefa2.setDescricao("Spring Data JPA");
            tarefa2.setDataEntrega(LocalDate.now().plusDays(1));
            tarefa2.setStatus(TarefaStatus.ABERTO);
            tarefa2.setVisivel(true);
            tarefa2.setCategoria(categoria);
            tarefa2.setUsuario(usuario);
            //salvar o registro no banco de dados
            tarefaRepository.save(tarefa2);
        };
    }
}
