package com.pfm.halterocms.daos;

import com.pfm.halterocms.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersDAO extends CrudRepository<User, Integer> {

    User findOneByUsernameAndPassword(String username, String password);
}
