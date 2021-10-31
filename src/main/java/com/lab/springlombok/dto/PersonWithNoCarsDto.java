package com.lab.springlombok.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Builder
public @Data class PersonWithNoCarsDto {
    @NotBlank(message = "is mandatory")
    private String name;
    @NotBlank(message = "is mandatory")
    private String lastname;
    @NotBlank(message = "is mandatory")
    @Email(message = "malformed email")
    private String email;
}
