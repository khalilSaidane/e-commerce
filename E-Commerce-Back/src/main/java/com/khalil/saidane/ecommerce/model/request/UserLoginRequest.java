package com.khalil.saidane.ecommerce.model.request;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String email;
    private String password;
}
