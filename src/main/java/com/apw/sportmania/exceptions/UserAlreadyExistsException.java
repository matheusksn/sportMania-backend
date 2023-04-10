package com.apw.sportmania.exceptions;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String email) {
        super("Já existe um usuário cadastrado com o email: " + email);
    }
}
