package com.chiquete.portafolio.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.chiquete.portafolio.Mail.EmailService;
import com.chiquete.portafolio.dtoClasses.MailDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ControllerRest {

    @PostMapping("/sendMail")
    public ResponseEntity<?> sendMail(@RequestBody MailDto mail) throws Exception {
        
        EmailService email=new EmailService();
        try{
            email.sendEmail(mail.getFrom(), "Contacto", mail.getMessage());
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
