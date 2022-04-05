package com.pfm.halterocms.controllers.monitoring;

import com.pfm.halterocms.daos.UsersDAO;
import com.pfm.halterocms.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
public class LoginController {

    private final UsersDAO usersDAO;

    public LoginController(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @GetMapping("/login")
    public String login(String username, String password) {
        try {
            User foundUser = usersDAO.findOneByUsernameAndPassword(username, getMd5(password));
            if(foundUser == null) {
                return "login-error";
            }
        } catch (Exception e) {
            return "login-error";
        }

        return "redirect:/show-competitions";
    }

    private String getMd5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());

            BigInteger signum = new BigInteger(1, messageDigest);
            StringBuilder hashtext = new StringBuilder(signum.toString(16));

            while (hashtext.length() < 32) {
                hashtext.insert(0, "0");
            }

            return hashtext.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
