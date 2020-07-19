package com.example.cos_swojego_sproboje_zrobic.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

public class DtoUserWithoutUuid {

    @NotBlank
    private final String username;

    @NotBlank
    private final String password;

    public DtoUserWithoutUuid(@JsonProperty("username") String username,
                              @JsonProperty("password") String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
