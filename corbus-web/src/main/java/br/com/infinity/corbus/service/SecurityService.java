package br.com.infinity.corbus.service;

/**
 * SecurityService.java
 *
 * @author @author Jean Santos <a href="mailto:jeanufu21@gmail.com">jeanufu21@gmail.com</a>
 * @since 2018-03-17
 */
public interface SecurityService {

    public String findLoggedInUsername();

    public void autologin(String username, String password);
}
