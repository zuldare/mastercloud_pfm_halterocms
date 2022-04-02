package com.pfm.halterocms.controllers.inscriptions;

import com.pfm.halterocms.daos.LiftersDAO;
import com.pfm.halterocms.models.Lifter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ShowInscribedLiftersController {

    private final LiftersDAO liftersDAO;

    public ShowInscribedLiftersController(LiftersDAO liftersDAO) {
        this.liftersDAO = liftersDAO;
    }

    @GetMapping("/show-inscribed-lifters/{competitionId}")
    public String getCompetitionLifters(@PathVariable("competitionId") Integer competitionId, Model model) {
        List<Lifter> competitionLifters = liftersDAO.findAllByCompetitionId(competitionId);
        model.addAttribute("lifters", competitionLifters);

        return "show-inscribed-lifters";
    }
}
