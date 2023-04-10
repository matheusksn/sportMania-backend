// Importações necessárias
package com.apw.sportmania.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Anotação que indica que esta classe é uma entidade JPA
@Data // Anotação do Lombok para gerar getters, setters, toString, equals e hashCode automaticamente
@Builder // Anotação do Lombok para criar padrão de projeto Builder
@NoArgsConstructor // Anotação do Lombok para gerar construtor sem argumentos
@AllArgsConstructor // Anotação do Lombok para gerar construtor com todos os argumentos
public class User {
    
    @Id // Anotação que indica que este atributo é a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotação que indica que a chave primária é gerada automaticamente pelo banco de dados
    private Long id;
    
    private String name;
    
    private String email;
    
    private String password;
    
    private boolean enabled;
    
    private String role;
    
    private String secret;
    
    private boolean isUsing2FA;
}
