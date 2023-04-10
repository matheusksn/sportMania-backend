package com.apw.sportmania.services;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.apw.sportmania.entities.User;
import com.apw.sportmania.exceptions.AuthenticationException;
import com.apw.sportmania.exceptions.InvalidCodeException;
import com.apw.sportmania.exceptions.UserAlreadyExistsException;
import com.apw.sportmania.repositories.UserRepository;
import com.apw.sportmania.utils.AuthUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AuthUtils authUtils;

    private final int TOKEN_VALIDITY_SECONDS = 30;

    public User registerUser(User user) throws UserAlreadyExistsException {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException();
        }

        String passwordHash = authUtils.hashPassword(user.getPassword());
        user.setPassword(passwordHash);

        String secret = authUtils.generateSecret();
        user.setSecret(secret);

        return userRepository.save(user);
    }

    public User authenticateUser(String email, String password, Integer code) throws AuthenticationException, InvalidCodeException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(AuthenticationException::new);

        if (!authUtils.checkPassword(password, user.getPassword())) {
            throw new AuthenticationException();
        }

        boolean isCodeValid = authUtils.authorize(user.getSecret(), code, Instant.now().getEpochSecond(), TOKEN_VALIDITY_SECONDS);
        if (!isCodeValid) {
            throw new InvalidCodeException();
        }

        return user;
    }
}
