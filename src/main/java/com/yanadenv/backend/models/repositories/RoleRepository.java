package com.yanadenv.backend.models.repositories;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.yanadenv.backend.models.entitys.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(String name);

}
