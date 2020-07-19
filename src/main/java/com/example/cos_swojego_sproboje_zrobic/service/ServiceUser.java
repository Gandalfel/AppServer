package com.example.cos_swojego_sproboje_zrobic.service;

import com.example.cos_swojego_sproboje_zrobic.model.entity.EntityUser;
import com.example.cos_swojego_sproboje_zrobic.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceUser {

    private final RepositoryUser repositoryUser;

    @Autowired
    public ServiceUser(RepositoryUser repositoryUser) {
        this.repositoryUser = repositoryUser;
    }


    public int createUser(String username, String password) {
        repositoryUser.save(new EntityUser(username, password));
        return 0;
    }

    public EntityUser getUserByUsername(String username) {
        return repositoryUser.findEntityUserByUsername(username);
    }

    public EntityUser getUserById(UUID id) {
        return repositoryUser.findEntityUserByUuid(id);
    }

    public List<EntityUser> getAllUsers() {
        return (List<EntityUser>) repositoryUser.findAll();
    }


    /*public int updateUserByUsername(String username) {

        return 0;
    }*/

    public int deleteUserByUsername(String username) {
        repositoryUser.deleteEntityUserByUsername(username);
        return 0;
    }
}
