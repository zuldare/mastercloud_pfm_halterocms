package com.pfm.halterocms.controllers.inscriptions;

import com.pfm.halterocms.daos.LiftersDAO;
import com.pfm.halterocms.models.Lifter;
import org.springframework.ui.Model;

import java.util.List;

public class ShowInscribedLiftersController {

    private final LiftersDAO liftersDAO;

    public ShowInscribedLiftersController(LiftersDAO liftersDAO) {
        this.liftersDAO = liftersDAO;
    }

    public String getCompetitionLifters(Integer competitionId, Model model) {

        List<Lifter> competitionLifters = liftersDAO.findAllByCompetitionId(competitionId);
        model.addAttribute("lifters", competitionLifters);

        return "competition-secretary-play";
    }
}
