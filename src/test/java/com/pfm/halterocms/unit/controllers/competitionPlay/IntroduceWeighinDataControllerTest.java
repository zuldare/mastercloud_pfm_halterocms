package com.pfm.halterocms.unit.controllers.competitionPlay;

import com.pfm.halterocms.controllers.competitionPlay.IntroduceWeighinDataController;
import com.pfm.halterocms.daos.WeighinsDAO;
import com.pfm.halterocms.models.Lifter;
import com.pfm.halterocms.models.Weighin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class IntroduceWeighinDataControllerTest {

    private final WeighinsDAO weighinsDAO = mock(WeighinsDAO.class);
    private final IntroduceWeighinDataController sut = new IntroduceWeighinDataController(weighinsDAO);

    @Test
    public void whenAddWeighinThenShouldCallDAOAndSaveTheNewWeighin() {
        Lifter lifter = new Lifter();
        double bodyWeight = 70.5;
        int snatchOpener = 90;
        int cleanAndJerkOpener = 85;

        Weighin weighinToBeAdded = new Weighin(
            lifter, bodyWeight, snatchOpener, cleanAndJerkOpener
        );

        when(weighinsDAO.save(weighinToBeAdded)).thenReturn(weighinToBeAdded);

        String targetView = sut.addWeighin(weighinToBeAdded);

        assertThat(targetView, is("redirect:/competition-secretary-play"));
        verify(weighinsDAO, times(1)).save(weighinToBeAdded);
    }

}
