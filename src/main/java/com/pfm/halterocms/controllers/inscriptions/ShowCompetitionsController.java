package com.pfm.halterocms.controllers.inscriptions;

import com.pfm.halterocms.daos.CompetitionsDAO;
import com.pfm.halterocms.models.Competition;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class ShowCompetitionsController {

    private final CompetitionsDAO competitionsDAO;

    public ShowCompetitionsController(CompetitionsDAO competitionsDAO) {
        this.competitionsDAO = competitionsDAO;
    }

    @GetMapping("/show-competitions")
    public String getCompetitions(Model model) {
        Iterable<Competition> competitions = competitionsDAO.findAll();
        model.addAttribute("competitions", competitions);

        return "show-competitions";
    }
}
