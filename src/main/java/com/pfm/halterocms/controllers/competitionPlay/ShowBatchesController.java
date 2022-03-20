package com.pfm.halterocms.controllers.competitionPlay;

import com.pfm.halterocms.daos.BatchesDAO;
import com.pfm.halterocms.models.Batch;
import org.springframework.ui.Model;

import java.util.List;

public class ShowBatchesController {

    private final BatchesDAO batchesDAO;

    public ShowBatchesController(BatchesDAO batchesDAO) {
        this.batchesDAO = batchesDAO;
    }

    public String getCompetitionBatches(String competitionId, Model model) {
        List<Batch> competitionBatches = batchesDAO.findByCompetitionId(competitionId);
        model.addAttribute("batches", competitionBatches);

        return "competition-secretary-edit-batch";
    }

}
