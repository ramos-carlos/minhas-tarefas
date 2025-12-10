package br.com.tarefas.repository;


import br.com.tarefas.model.ERole;
import br.com.tarefas.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(ERole name);
}
