package br.com.dequebra.fintech.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping
    public  String hello(){
        return "Hello World!";
    }

    @GetMapping("/fiap")
    public String fiap(){
        return "Aluno Fiap";
    }
}
