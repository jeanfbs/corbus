package br.com.infinity.corbus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cpanel/parceiros")
public class ParceiroController {

    @GetMapping("/")
    public ModelAndView consultaParceiro() {
        return new ModelAndView("pages/parceiros/consulta");
    }


    @GetMapping("/novo")
    public ModelAndView cadastroParceiro() {
        return new ModelAndView("pages/parceiros/cadastro");
    }

}
