package hu.acsaifz.jwtdemo.repository;

import hu.acsaifz.jwtdemo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
