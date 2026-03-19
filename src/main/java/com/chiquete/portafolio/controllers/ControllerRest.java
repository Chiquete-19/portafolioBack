package com.chiquete.portafolio.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ControllerRest {

    @PostMapping("/sendMail")
    public void sendMail(@RequestBody RequestBody request) {
        
    }
    
}
