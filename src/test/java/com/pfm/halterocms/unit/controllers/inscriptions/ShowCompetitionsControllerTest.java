package com.pfm.halterocms.unit.controllers.inscriptions;

import com.pfm.halterocms.controllers.inscriptions.ShowCompetitionsController;
import com.pfm.halterocms.daos.CompetitionsDAO;
import com.pfm.halterocms.models.Competition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class ShowCompetitionsControllerTest {

    private final CompetitionsDAO competitionsDAO = mock(CompetitionsDAO.class);
    private final ShowCompetitionsController sut = new ShowCompetitionsController(competitionsDAO);

    @Test
    public void whenGetCompetitionsThenShouldCallDAOAndRetrieveTheCompetitions() {
        Model model = mock(Model.class);

        List<Competition> competitions = Arrays.asList(new Competition(), new Competition(), new Competition());

        when(competitionsDAO.findAll()).thenReturn(competitions);

        String targetView = sut.getCompetitions(model);

        assertThat(targetView, is("show-competitions"));
        verify(competitionsDAO, times(1)).findAll();
        verify(model).addAttribute("competitions", competitions);
    }
}
