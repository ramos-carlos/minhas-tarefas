package br.com.facint.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.facint.model.Tarefa;
import br.com.facint.model.TarefaCategoria;
import br.com.facint.model.TarefaStatus;
import br.com.facint.model.Usuario;
import br.com.facint.repository.TarefaCategoriaRepository;
import br.com.facint.repository.TarefaRepository;
import br.com.facint.repository.UsuarioRepository;

@Configuration
//@Profile("dev")
public class CarregaBaseDeDados {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TarefaCategoriaRepository categoriaRepository;
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Bean
	CommandLineRunner executar(UsuarioRepository usuarioRepository, TarefaCategoriaRepository categoriaRepository, TarefaRepository tarefaRepository) {
		return args -> {
			Usuario usuario = new Usuario();
			usuario.setNome("Admin");
			usuario.setSenha("123456");
			usuarioRepository.save(usuario);
			
			TarefaCategoria categoria = new TarefaCategoria();
			categoria.setNome("Estudos");
			categoriaRepository.save(categoria);
			
			Tarefa tarefa = new Tarefa();
			tarefa.setDescricao("Aprender Spring Boot");
			tarefa.setDataEntrega(LocalDate.now().plusDays(1));
			tarefa.setStatus(TarefaStatus.ABERTO);
			tarefa.setVisivel(true);
			tarefa.setCategoria(categoria);
			tarefa.setUsuario(usuario);
			tarefaRepository.save(tarefa);
		};
	}
}
