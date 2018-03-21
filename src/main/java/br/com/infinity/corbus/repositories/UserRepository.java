package br.com.infinity.corbus.repositories;

import br.com.infinity.corbus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository.java
 *
 * @author @author Jean Santos <a href="mailto:jeanufu21@gmail.com">jeanufu21@gmail.com</a>
 * @since 2018-03-17
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
