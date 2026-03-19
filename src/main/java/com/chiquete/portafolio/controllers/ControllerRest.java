package com.chiquete.portafolio.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.chiquete.portafolio.dtoClasses.MailDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ControllerRest {

    @PostMapping("/sendMail")
    public void sendMail(@RequestBody MailDto mail) {
        
    }
}
