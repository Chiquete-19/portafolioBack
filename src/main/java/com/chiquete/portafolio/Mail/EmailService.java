package com.chiquete.portafolio.Mail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class EmailService {

    @Value("${app.api.key}")
    private String API_KEY;

    public void sendEmail(String fromUser, String message) throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://api.resend.com/emails";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = new HashMap<>();
        body.put("from", "onboarding@resend.dev"); // 👈 IMPORTANTE
        body.put("to", List.of("lacuentadefer2003@gmail.com"));
        body.put("subject", "Nuevo mensaje");

        body.put("html",
                "<p><strong>De:</strong> " + fromUser + "</p>" +
                "<p>" + message + "</p>"
        );

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody());
    }
}
