package com.example.cos_swojego_sproboje_zrobic.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "user")
public class EntityUser implements Serializable {

    public EntityUser(){}

    public EntityUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Id
    @Column(length = 16, unique = true, nullable = false)
    private UUID uuid = UUID.randomUUID();

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public UUID getUuid() {
        return uuid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
