package com.uz.aeroport.entity;

import javax.persistence.*;

/**
 * Created by Jack on 20.01.2019.
 */
@Entity
@Table(name = "userss")
public class UserEntity
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "login")
    private String login;

    @Column
    private String passwords;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }
}
