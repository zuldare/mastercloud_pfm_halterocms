package com.pfm.halterocms.controllers.monitoring;

import com.pfm.halterocms.daos.UsersDAO;

public class LoginController {

    private final UsersDAO usersDAO;

    public LoginController(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    public String login(String username, String password) {
        usersDAO.findByUsernameAndPassword(username, password);
        return "competition-secretary";
    }
}
