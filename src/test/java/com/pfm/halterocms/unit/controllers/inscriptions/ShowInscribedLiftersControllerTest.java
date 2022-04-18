package com.pfm.halterocms.unit.controllers.inscriptions;

import com.pfm.halterocms.controllers.inscriptions.ShowInscribedLiftersController;
import com.pfm.halterocms.daos.LiftersDAO;
import com.pfm.halterocms.models.Lifter;
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
class ShowInscribedLiftersControllerTest {

    private final LiftersDAO liftersDAO = mock(LiftersDAO.class);
    private final ShowInscribedLiftersController sut = new ShowInscribedLiftersController(liftersDAO);

    @Test
    void whenShowInscribedLiftersThenShouldCallDAOAndRetrieveTheLiftersAndWeighins() {
        Integer competitionId = 123;
        Model model = mock(Model.class);

        List<Lifter> lifters = Arrays.asList(new Lifter(), new Lifter(), new Lifter());

        when(liftersDAO.findAllByCompetitionId(competitionId)).thenReturn(lifters);

        String targetView = sut.getCompetitionLifters(competitionId, model);

        assertThat(targetView, is("show-inscribed-lifters"));
        verify(liftersDAO, times(1)).findAllByCompetitionId(competitionId);
        verify(model).addAttribute("lifters", lifters);
    }
}
