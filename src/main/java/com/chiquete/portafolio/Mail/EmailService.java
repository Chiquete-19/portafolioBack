package com.chiquete.portafolio.Mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service
public class EmailService {

    @Value("${app.api.key}")
    private String API_KEY;

    public void sendEmail(String to, String subject, String content) throws Exception {

        Email from = new Email("lacuentadefer2003@gmail.com");
        Email toEmail = new Email(to);

        Content body = new Content("text/html", content);
        Mail mail = new Mail(toEmail, subject, from, body);

        SendGrid sg = new SendGrid(System.getenv(API_KEY));
        Request request = new Request();

        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        sg.api(request);
    }
}
