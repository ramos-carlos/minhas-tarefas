package br.com.tarefas.repository;

import br.com.tarefas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

//spring data
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
