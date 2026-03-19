package com.chiquete.portafolio.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.chiquete.portafolio.Mail.EmailService;
import com.chiquete.portafolio.dtoClasses.MailDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ControllerRest {

    @Autowired
    private EmailService email;

    @PostMapping("/sendMail")
    public ResponseEntity<?> sendMail(@RequestBody MailDto mail) throws Exception {
        
        try {
            String from=mail.getFrom();
            String mensaje= mail.getMessage();
            email.sendEmail(from,mensaje);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace(); // 👈 AGREGA ESTO
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
