package com.example.cos_swojego_sproboje_zrobic.controller;

import com.example.cos_swojego_sproboje_zrobic.model.dto.DtoUserWithUuid;
import com.example.cos_swojego_sproboje_zrobic.model.dto.DtoUserWithoutUuid;
import com.example.cos_swojego_sproboje_zrobic.model.entity.EntityUser;
import com.example.cos_swojego_sproboje_zrobic.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/user")
@RestController
public class ControllerUser {

    private ServiceUser serviceUser;

    @Autowired
    public ControllerUser(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @PostMapping(path = "/create")
    private void createUser(@Valid @NonNull @RequestBody DtoUserWithoutUuid dtoUser) {
        serviceUser.createUser(dtoUser.getUsername(), dtoUser.getPassword());
    }

    @GetMapping(path = "/get/{id}")
    private DtoUserWithUuid getUserById(@PathVariable("id") UUID uuid) {
        return new DtoUserWithUuid(serviceUser.getUserById(uuid).getUuid(),
                                    serviceUser.getUserById(uuid).getUsername(),
                                    serviceUser.getUserById(uuid).getPassword());
    }

    @GetMapping(path = "/get")
    private List<DtoUserWithUuid> getAllUsers() {
        List<EntityUser> listOfEntityUser = serviceUser.getAllUsers();
        List<DtoUserWithUuid> listOfDtoUser = new ArrayList<>();

        listOfEntityUser.forEach(e -> {
            listOfDtoUser.add(new DtoUserWithUuid(e.getUuid(), e.getUsername(), e.getPassword()));
        });

        return listOfDtoUser;
    }
}
