package com.pfm.halterocms.unit.controllers.competitionPlay;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.pfm.halterocms.controllers.competitionPlay.ShowBatchInPlayController;
import com.pfm.halterocms.daos.BatchLiftersDAO;
import com.pfm.halterocms.daos.BatchesDAO;
import com.pfm.halterocms.daos.LiftDAO;
import com.pfm.halterocms.models.Batch;
import com.pfm.halterocms.models.BatchLifter;
import com.pfm.halterocms.models.Competition;
import com.pfm.halterocms.models.Countdown;
import com.pfm.halterocms.models.Lift;
import com.pfm.halterocms.models.LiftStatus;
import com.pfm.halterocms.models.LiftType;
import com.pfm.halterocms.models.Lifter;
import com.pfm.halterocms.models.Weighin;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.Model;

@ExtendWith(SpringExtension.class)
public class ShowBatchInPlayControllerTest {

	private final BatchesDAO batchesDAO = mock(BatchesDAO.class);
	private final LiftDAO liftDAO = mock(LiftDAO.class);
	private final BatchLiftersDAO batchLiftersDAO = mock(BatchLiftersDAO.class);

	private final ShowBatchInPlayController sut = new ShowBatchInPlayController(batchesDAO, liftDAO, batchLiftersDAO);

	@Test
	void testEditLiftWhenThereAreNoLiftsInBatch_shouldReturnAnEmptyModel(){
		Model model = mock(Model.class);

		Integer batchId = 999;

		String targetView = sut.getLiftsFromBatch(batchId, model);

		assertEquals(targetView, "show-batch-in-play");
		verify(batchLiftersDAO, times(1)).findAllByBatchId(batchId);
		verify(model).addAttribute("lifts", Map.of());
	}

//	@Test
	void testEditLiftWhenThereAreLiftsInBatch_shouldReturnModelWithLifts(){
		Model model = mock(Model.class);

		Integer batchId = 999;

		Competition competition = generateCompetition();

		Lifter lifter = getLifter();
		List<Lift> lifts = getLifts();

		when(batchLiftersDAO.findAllByBatchId(999)).thenReturn(generateBatchLifters());

		String targetView = sut.getLiftsFromBatch(batchId, model);

		assertEquals(targetView, "show-competition-batches-with-lifts");
		verify(batchLiftersDAO, times(1)).findAllByBatchId(batchId);
		verify(model).addAttribute("lifts", Map.of());
	}


	private Competition generateCompetition(){
		LocalDate inscriptionStartDate = LocalDate.of(2022, 10,2);
		LocalDate startDate = LocalDate.of(2022, 12, 15);

		Competition competition = new Competition(1, "Competititon Test", "Senior", "Madrid", "FEH", inscriptionStartDate, inscriptionStartDate.plusMonths(1), startDate, startDate.plusDays(1));
		Batch batch = new Batch(2, competition, "A", "M", startDate, LocalTime.of(8,0), LocalTime.of(10,0));

		Lifter anatoly = new Lifter(3, "Pisarenko", "URSS", "1985", "M019", batch);
		Lifter mata = new Lifter(3, "Mata", "Spain", "1980", "M019", batch);

		// new BatchLifter(Integer id, Integer drawOrder, Batch batch, Lifter lifter, Weighin weighin);

		return null;
	}






	private Lifter getLifter(){
		Lifter lifter = new Lifter();
		return lifter;
	}
	private List<Lift> getLifts(){
		Lift sn1 = new Lift();
		sn1.setId(146);
		sn1.setBatchLifterId(1);
		sn1.setStatus(LiftStatus.PENDING.getValue());
		sn1.setType(LiftType.SNATCH.getValue());
		sn1.setCountdown(Countdown.ONE_MINUTE.getValue());
		sn1.setBatchLifterId(1);
		sn1.setBarSetWeight(150);

		Lift cj1 = new Lift();
		cj1.setId(146);
		cj1.setBatchLifterId(1);
		cj1.setStatus(LiftStatus.PENDING.getValue());
		cj1.setType(LiftType.SNATCH.getValue());
		cj1.setCountdown(Countdown.ONE_MINUTE.getValue());
		cj1.setBatchLifterId(1);
		cj1.setBarSetWeight(150);

		return List.of(sn1, cj1);
	}

	private List<BatchLifter> generateBatchLifters(){
		Batch batch = new Batch();

		BatchLifter batchLifter = new BatchLifter(1,1, batch, new Lifter(), new Weighin() );

		return List.of(batchLifter);
	}
}
