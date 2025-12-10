package br.com.tarefas.repository;

import br.com.tarefas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//spring data
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNome(String username);
}
