package com.asps.graphqlcatalog.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorTestController {

    @GetMapping("/teste-erro-apm")
    public String testeErroApm() {

        throw new RuntimeException(
                "Erro de teste para validar Elastic APM");
    }
}