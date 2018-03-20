package br.com.infinity.corbus.controller;

import br.com.infinity.corbus.entity.User;
import br.com.infinity.corbus.service.SecurityService;
import br.com.infinity.corbus.service.UserService;
import br.com.infinity.corbus.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * LoginController.java
 *
 * @author @author Jean Santos <a href="mailto:jeanufu21@gmail.com">jeanufu21@gmail.com</a>
 * @since 2018-03-17
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity registration(@RequestBody User userForm) {

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity list() {

        List<User> lista = userService.list();

        return ResponseEntity.ok(lista);
    }
}
