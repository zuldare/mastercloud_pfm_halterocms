package com.pfm.halterocms.unit.controllers.monitoring;

import com.pfm.halterocms.controllers.monitoring.LoginController;
import com.pfm.halterocms.daos.UsersDAO;
import com.pfm.halterocms.models.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class LoginControllerTest {

    private final String username = "user";
    private final String password = "pass";
    private final String encryptedPassword = "1a1dc91c907325c69271ddf0c944bc72";

    private final UsersDAO usersDAO = mock(UsersDAO.class);
    private final LoginController sut = new LoginController(usersDAO);

    @Test
    void whenLogin_ThenShouldCallDAO_AndFindCompetitionSecretary_AndReturnCompetitionSecretaryView() {
        User foundUser = new User(username, encryptedPassword);

        when(usersDAO.findOneByUsernameAndPassword(username, encryptedPassword)).thenReturn(Optional.of(foundUser));

        String targetView = sut.login(username, password);

        assertThat(targetView, is("redirect:/show-competitions"));
        verify(usersDAO, times(1)).findOneByUsernameAndPassword(username, encryptedPassword);
    }

    @Test
    void whenLoginFails_ThenShouldCallDAOWithoutFindingAnyUser_AndReturnErrorView() {

        when(usersDAO.findOneByUsernameAndPassword(username, encryptedPassword)).thenReturn(Optional.empty());

        String targetView = sut.login(username, password);

        assertThat(targetView, is("error/login-error"));
        verify(usersDAO, times(1)).findOneByUsernameAndPassword(username, encryptedPassword);
    }
}
