package com.pfm.halterocms.unit.controllers.competitionPlay;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.pfm.halterocms.controllers.competitionPlay.EditLiftController;
import com.pfm.halterocms.daos.BatchLiftersDAO;
import com.pfm.halterocms.daos.BatchesDAO;
import com.pfm.halterocms.daos.LiftDAO;
import com.pfm.halterocms.models.Batch;
import com.pfm.halterocms.models.BatchLifter;
import com.pfm.halterocms.models.Competition;
import com.pfm.halterocms.models.Lift;
import com.pfm.halterocms.models.Lifter;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.Model;

@ExtendWith(SpringExtension.class)
public class EditLiftControllerTest {

	private final BatchesDAO batchesDAO = mock(BatchesDAO.class);
	private final LiftDAO liftDAO = mock(LiftDAO.class);
	private final BatchLiftersDAO batchLiftersDAO = mock(BatchLiftersDAO.class);

	private final EditLiftController sut = new EditLiftController(batchesDAO, liftDAO, batchLiftersDAO);


	@Test
	void testEditLiftWhenThereAreNoLiftsInBatch_shouldReturnAnEmptyModel(){
		Model model = mock(Model.class);

		Integer batchId = 999;

		String targetView = sut.getLiftsFromBatch(batchId, model);

		assertEquals(targetView, "show-competition-batches-with-lifts");
		verify(batchLiftersDAO, times(1)).findAllByBatchId(batchId);
		verify(model).addAttribute("lifts", Map.of());
	}

}
