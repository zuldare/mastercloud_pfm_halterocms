package com.pfm.halterocms.unit.controllers.competitionPlay;

import com.pfm.halterocms.controllers.competitionPlay.ShowBatchesController;
import com.pfm.halterocms.daos.BatchesDAO;
import com.pfm.halterocms.models.Batch;
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
public class ShowBatchesControllerTest {

    private final BatchesDAO batchesDAO = mock(BatchesDAO.class);
    private final ShowBatchesController sut = new ShowBatchesController(batchesDAO);

    @Test
    public void whenGetCompetitionBatchesThenShouldCallDAOAndRetrieveTheBatches() {
        Integer competitionId = 123;
        Model model = mock(Model.class);

        List<Batch> batches = Arrays.asList(new Batch(), new Batch(), new Batch());

        when(batchesDAO.findByCompetitionId(competitionId)).thenReturn(batches);

        String targetView = sut.getCompetitionBatches(competitionId, model);

        assertThat(targetView, is("competition-secretary-edit-batch"));
        verify(batchesDAO, times(1)).findByCompetitionId(competitionId);
        verify(model).addAttribute("batches", batches);
    }
}
