package com.pfm.halterocms.daos;

import com.pfm.halterocms.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsersDAO extends CrudRepository<User, Integer> {

    Optional<User> findOneByUsernameAndPassword(String username, String password);
}
