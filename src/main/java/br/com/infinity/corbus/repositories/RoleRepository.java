package br.com.infinity.corbus.repositories;

import br.com.infinity.corbus.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * RoleRepository.java
 *
 * @author @author Jean Santos <a href="mailto:jeanufu21@gmail.com">jeanufu21@gmail.com</a>
 * @since 2018-03-17
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
