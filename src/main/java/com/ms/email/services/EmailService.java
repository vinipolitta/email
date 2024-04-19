package com.ms.email.services;

import com.ms.email.models.Contact;
import com.ms.email.models.Emails;
import com.ms.email.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    ContactRepository contactRepository;

    public void sendEmail(Emails email) {
//        contactRepository.save(contact);
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailSender.send(mailMessage);

        var contact = new Contact(email);

        contactRepository.save(contact);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("vinicius.politta.santos@outlook.com");
        mailMessage.setTo(email.name());
        mailMessage.setSubject("Novo contato de: " + email.subject());
        mailMessage.setText("Nome do cliente: " + email.name() + "\nTelefone do cliente: " + email.phone() + "\nNovo contato de: " + email.subject() + "\nMensagem: " + email.message() + "\nE-mail: " + email.email());
        mailSender.send(mailMessage);

    }

}
