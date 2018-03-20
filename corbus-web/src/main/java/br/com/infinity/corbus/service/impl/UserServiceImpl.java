package br.com.infinity.corbus.service.impl;

import br.com.infinity.corbus.entity.User;
import br.com.infinity.corbus.repositories.RoleRepository;
import br.com.infinity.corbus.repositories.UserRepository;
import br.com.infinity.corbus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * UserServiceImpl.java
 *
 * @author @author Jean Santos <a href="mailto:jeanufu21@gmail.com">jeanufu21@gmail.com</a>
 * @since 2018-03-17
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        user.getRoles().forEach(role -> {
            roleRepository.save(role);
        });
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User find(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }
}
