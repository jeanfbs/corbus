package br.com.infinity.corbus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping("/auth")
    public ModelAndView login() {
        return new ModelAndView("pages/login");
    }

    @GetMapping("/login-error")
    public ModelAndView loginError(Model model) {
        model.addAttribute("loginError", true);
        return new ModelAndView("pages/login");
    }

}
