package com.ms.email.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;


@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String name;
    @Email
    private String email;
    private String phone;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String message;


    public Contact(Emails email) {
        this.name = email.name();
        this.email = email.email();
        this.phone = email.phone();
        this.subject = email.subject();
        this.message = email.message();
    }
}
