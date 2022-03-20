package com.pfm.halterocms.unit.controllers.monitoring;

import com.pfm.halterocms.controllers.monitoring.LoginController;
import com.pfm.halterocms.daos.UsersDAO;
import com.pfm.halterocms.models.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class LoginControllerTest {

    private final UsersDAO usersDAO = mock(UsersDAO.class);
    private final LoginController sut = new LoginController(usersDAO);

    @Test
    public void whenLoginThenShouldCallDAOAndFindCompetitionSecretaryProperly() {
        String username = "user";
        String password = "pass";
        User foundUser = new User(username, password);

        when(usersDAO.findByUsernameAndPassword(username, password)).thenReturn(foundUser);

        String targetView = sut.login(username, password);

        assertThat(targetView, is("competition-secretary"));
        verify(usersDAO, times(1)).findByUsernameAndPassword(username, password);
    }
}
