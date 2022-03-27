package com.pfm.halterocms.unit.controllers.competitionPlay;

import com.pfm.halterocms.controllers.competitionPlay.ShowCompetitionBatchesController;
import com.pfm.halterocms.daos.BatchesDAO;
import com.pfm.halterocms.daos.CompetitionsDAO;
import com.pfm.halterocms.models.Batch;
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
public class ShowCompetitionBatchesControllerTest {

    private final BatchesDAO batchesDAO = mock(BatchesDAO.class);
    private final CompetitionsDAO competitionsDAO = mock(CompetitionsDAO.class);
    private final ShowCompetitionBatchesController sut = new ShowCompetitionBatchesController(batchesDAO, competitionsDAO);

    @Test
    public void whenGetCompetitionBatchesThenShouldCallDAOAndRetrieveTheBatches() {
        Integer competitionId = 123;
        Model model = mock(Model.class);

        Competition batchesCompetition = new Competition();
        Batch batch = new Batch();
        List<Batch> batches = Arrays.asList(batch, batch, batch);

        when(batchesDAO.findByCompetitionId(competitionId)).thenReturn(batches);
        when(competitionsDAO.findById(competitionId)).thenReturn(java.util.Optional.of(batchesCompetition));

        String targetView = sut.getCompetitionBatches(competitionId, model);

        assertThat(targetView, is("show-competition-batches"));
        verify(batchesDAO, times(1)).findByCompetitionId(competitionId);
        verify(model).addAttribute("batchesCompetition", batchesCompetition);
        verify(model).addAttribute("batches", batches);
    }
}
