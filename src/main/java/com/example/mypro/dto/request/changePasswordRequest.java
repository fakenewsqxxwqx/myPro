package com.example.mypro.dto.request;

import lombok.Data;

@Data
public class changePasswordRequest {
    private String mail;
    private String code;
    private String password;
}
