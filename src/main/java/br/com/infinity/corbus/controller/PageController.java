package br.com.infinity.corbus.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cpanel")
public class PageController {



    @GetMapping(value = "/other", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity dash(){

        UserDetails userDetailobj = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        System.out.println(userDetailobj.getUsername());
        return ResponseEntity.ok("{ \"message\":\"Dashboard Page\"}");
    }



}
