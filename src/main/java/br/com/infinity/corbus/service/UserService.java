package br.com.infinity.corbus.service;

import br.com.infinity.corbus.entity.User;

import java.util.List;

/**
 * UserService.java
 *
 * @author @author Jean Santos <a href="mailto:jeanufu21@gmail.com">jeanufu21@gmail.com</a>
 * @since 2018-03-17
 */
public interface UserService {

    void save(User user);

    User find(String username);


    List<User> list();

}
