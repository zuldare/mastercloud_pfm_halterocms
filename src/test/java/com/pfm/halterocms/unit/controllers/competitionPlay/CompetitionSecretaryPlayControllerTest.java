package com.pfm.halterocms.unit.controllers.competitionPlay;

import com.pfm.halterocms.controllers.competitionPlay.CompetitionSecretaryPlayController;
import com.pfm.halterocms.daos.BatchLiftersDAO;
import com.pfm.halterocms.daos.WeighinsDAO;
import com.pfm.halterocms.dtos.WeighinDataDto;
import com.pfm.halterocms.models.*;
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
public class CompetitionSecretaryPlayControllerTest {

    private final BatchLiftersDAO batchLiftersDAO = mock(BatchLiftersDAO.class);
    private final WeighinsDAO weighinsDAO = mock(WeighinsDAO.class);

    private final CompetitionSecretaryPlayController sut = new CompetitionSecretaryPlayController(batchLiftersDAO, weighinsDAO);

    @Test
    public void whenShowCompetitionPlayThenShouldCallDAOAndRetrieveAllLiftersData() {
        Integer batchId = 123;
        Model model = mock(Model.class);

        BatchLifter batchLifter = mock(BatchLifter.class);
        Batch liftersBatch = new Batch();
        when(batchLifter.getBatch()).thenReturn(liftersBatch);

        List<BatchLifter> batchLifters = Arrays.asList(batchLifter, batchLifter, batchLifter);
        when(batchLiftersDAO.findAllByBatchId(batchId)).thenReturn(batchLifters);

        String targetView = sut.getBatchLifters(batchId, model);

        assertThat(targetView, is("show-competition-play"));
        verify(batchLiftersDAO, times(1)).findAllByBatchId(batchId);
        verify(model).addAttribute("batchLifters", batchLifters);
        verify(model).addAttribute("batch", liftersBatch);
    }

    @Test
    public void whenIntroduceWeighinDataThenShouldCallDAOsAndSaveItProperly() {
        Integer batchId = 1234;
        Integer batchLifterId = 4321;
        Integer drawOrder = 4;

        double bodyWeight = 70.5;
        int snatchOpener = 90;
        int cleanAndJerkOpener = 85;

        Lifter lifter = new Lifter();
        Batch batch = new Batch();
        BatchLifter foundBatchLifter = new BatchLifter(
                batchLifterId, drawOrder, batch, lifter, null
        );

        WeighinDataDto weighinData = new WeighinDataDto(
                batchId, drawOrder, bodyWeight, snatchOpener, cleanAndJerkOpener);
        Weighin weighinToBeAdded = new Weighin();
        BatchLifter expectedBatchLifterToBeUpdated = new BatchLifter(
                batchLifterId, drawOrder, batch, lifter, weighinToBeAdded
        );

        when(batchLiftersDAO.findOneByBatchIdAndDrawOrder(batchId, drawOrder))
                .thenReturn(foundBatchLifter);
        when(weighinsDAO.save(any(Weighin.class))).thenReturn(weighinToBeAdded);

        String targetView = sut.introduceWeighinData(weighinData);

        assertThat(targetView, is("redirect:/show-competition-play/1234"));
        verify(batchLiftersDAO, times(1)).findOneByBatchIdAndDrawOrder(batchId, drawOrder);
        verify(batchLiftersDAO, times(1)).save(expectedBatchLifterToBeUpdated);
    }

}
