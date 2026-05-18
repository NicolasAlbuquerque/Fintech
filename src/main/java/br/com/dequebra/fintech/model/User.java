package br.com.dequebra.fintech.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
        (name = "t_user",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "un_email",
                        columnNames = "email"
                ),
                @UniqueConstraint(
                        name = "un_cpf",
                        columnNames = "cpf"
                )
        }
        )
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_USERS"
    )
    @SequenceGenerator(
            name = "SEQ_USERS",
            sequenceName = "SEQ_USERS",
            allocationSize = 1
    )
    @Column(name = "id_user")
    private Long id;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(name = "password_hash", length = 255, nullable = false)
    private String password;

    @Column(length = 100, nullable = false)
    private String username;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(length = 11, nullable = false)
    private String cpf;

    public User(){}

    public User(Long id, String email, String password, String username, LocalDate birthDate, String cpf) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.birthDate = birthDate;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
