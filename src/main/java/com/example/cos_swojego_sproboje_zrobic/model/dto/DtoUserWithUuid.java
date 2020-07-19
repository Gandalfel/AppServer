package com.example.cos_swojego_sproboje_zrobic.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class DtoUserWithUuid {

    @NotBlank
    private final UUID uuid;

    @NotBlank
    private final String username;

    @NotBlank
    private final String password;

    public DtoUserWithUuid(@JsonProperty("uuid") UUID uuid,
                   @JsonProperty("username") String username,
                   @JsonProperty("password") String password) {
        this.uuid = uuid;
        this.username = username;
        this.password = password;
    }

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
