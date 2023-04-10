package com.apw.sportmania.exceptions;

public class InvalidCodeException extends Exception {
    public InvalidCodeException() {
        super("Código de autenticação inválido");
    }
}
