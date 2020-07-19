package com.example.cos_swojego_sproboje_zrobic.repository;

import com.example.cos_swojego_sproboje_zrobic.model.entity.EntityUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositoryUser extends CrudRepository<EntityUser, UUID> {

    EntityUser save(EntityUser entityUser);
    EntityUser findEntityUserByUsername(String username);
    EntityUser findEntityUserByUuid(UUID uuid);
    void deleteEntityUserByUsername(String username);
}
