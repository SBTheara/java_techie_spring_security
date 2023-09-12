package com.intern.theara.springsecurity.JavaTechie_SpringSecurity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String email;
    private String password;
}
