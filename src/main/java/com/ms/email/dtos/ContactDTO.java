package com.ms.email.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;


public record ContactDTO(
        String ful_name,
        String email,
        String phone_number,
        String subject,
        String text
) {
}
