package com.sipi.webstore.services;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSendlerService {

    private final JavaMailSender mailSender;

    public void sendEmail(String toEmail,
                          String subject,
                          String body) {
        //JavaMailSenderImpl mailSender1 = new JavaMailSenderImpl();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("pyatkin.nikitka@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);

    }
}
