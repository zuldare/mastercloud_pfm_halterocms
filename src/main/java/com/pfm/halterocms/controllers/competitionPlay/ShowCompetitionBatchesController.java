package com.pfm.halterocms.controllers.competitionPlay;

import com.pfm.halterocms.daos.BatchesDAO;
import com.pfm.halterocms.daos.CompetitionsDAO;
import com.pfm.halterocms.models.Batch;
import com.pfm.halterocms.models.Competition;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ShowCompetitionBatchesController {

    private final BatchesDAO batchesDAO;
    private final CompetitionsDAO competitionsDAO;

    public ShowCompetitionBatchesController(BatchesDAO batchesDAO, CompetitionsDAO competitionsDAO) {
        this.batchesDAO = batchesDAO;
        this.competitionsDAO = competitionsDAO;
    }

    @GetMapping("/show-competition-batches/{competitionId}")
    public String getCompetitionBatches(@PathVariable("competitionId") Integer competitionId, Model model) {
        List<Batch> competitionBatches = batchesDAO.findByCompetitionId(competitionId);
        Competition batchesCompetition = competitionsDAO.findById(competitionId).orElse(null);

        model.addAttribute("batches", competitionBatches);
        model.addAttribute("batchesCompetition", batchesCompetition);

        return "show-competition-batches";
    }

}
