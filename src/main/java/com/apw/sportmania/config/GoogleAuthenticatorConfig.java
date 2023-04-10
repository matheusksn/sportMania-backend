package com.apw.sportmania.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.warrenstrange.googleauth.GoogleAuthenticator;

@Configuration
public class GoogleAuthenticatorConfig {

    /**
     * Cria uma instância do GoogleAuthenticator.
     *
     * @return a instância criada
     */
    @Bean
    public GoogleAuthenticator gAuth() {
        return new GoogleAuthenticator();
    }
}
