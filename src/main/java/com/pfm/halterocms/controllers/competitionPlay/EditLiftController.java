package com.pfm.halterocms.controllers.competitionPlay;

import com.pfm.halterocms.daos.BatchLiftersDAO;
import com.pfm.halterocms.daos.BatchesDAO;
import com.pfm.halterocms.daos.LiftDAO;
import com.pfm.halterocms.models.BatchLifter;
import com.pfm.halterocms.models.Lift;
import com.pfm.halterocms.models.Lifter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//TODO
@Controller
public class EditLiftController {

	private final BatchesDAO batchesDAO;
	private final LiftDAO liftDAO;
	private final BatchLiftersDAO batchLiftersDAO;


	public EditLiftController(BatchesDAO batchesDAO, LiftDAO liftDAO, BatchLiftersDAO batchLiftersDAO) {
		this.batchesDAO = batchesDAO;
		this.liftDAO = liftDAO;
		this.batchLiftersDAO = batchLiftersDAO;
	}

	@GetMapping("/show-batch-lifts/{batchId}")
	public String getLiftsFromBatch(@PathVariable("batchId")Integer batchId, Model model){
		    	batchLiftersDAO.findAllByBatchId(batchId)
					.stream()
					.map(batchLifter -> batchLifter.getLifts())
					.collect(Collectors.toList());

				Map<Lifter, List<Lift>> lifts = batchLiftersDAO.findAllByBatchId(batchId)
					.stream()
						.collect(Collectors.toMap(BatchLifter::getLifter, BatchLifter::getLifts));

				model.addAttribute("lifts", lifts);
				//TODO => modify show-competition-play in order to add lift map
				return "";
	}

}
