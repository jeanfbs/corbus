package br.com.infinity.corbus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cpanel")
public class DashboardController {



    @GetMapping("/dashboard")
    public ModelAndView login() {
        return new ModelAndView("layouts/root");
    }

}
