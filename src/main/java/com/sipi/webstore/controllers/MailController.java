package com.sipi.webstore.controllers;

import com.sipi.webstore.models.Mail;
import com.sipi.webstore.services.EmailSendlerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MailController {

    private final EmailSendlerService sendlerService;

    @PostMapping("/mail")
    public void sendMail(@RequestBody Mail mail)
    {
        sendlerService.sendEmail(mail.getMail(), mail.getTheme(), mail.getMessage());
    }

}
