package com.apw.sportmania.entities;

import lombok.Data;

@Data
public class UserCredentials {
    private String email;
    private String password;
    private Integer code;
}