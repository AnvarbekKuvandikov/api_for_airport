package com.uz.aeroport.entity;

import javax.persistence.*;

/**
 * Created by Jack on 20.01.2019.
 */
@Entity
@Table(name = "userss")
public class UserCheckEntity
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "login")
    private String login;

    @Column
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
