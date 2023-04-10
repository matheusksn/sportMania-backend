package com.apw.sportmania.exceptions;

public class AuthenticationException extends Exception {
    public AuthenticationException() {
        super("Credenciais inválidas");
    }
}
