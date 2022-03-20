package com.pfm.halterocms.controllers.inscriptions;

import com.pfm.halterocms.daos.CompetitionsDAO;
import com.pfm.halterocms.models.Competition;
import org.springframework.ui.Model;

import java.util.List;

public class ShowCompetitionsController {

    private final CompetitionsDAO competitionsDAO;

    public ShowCompetitionsController(CompetitionsDAO competitionsDAO) {
        this.competitionsDAO = competitionsDAO;
    }

    public String getCompetitions(Model model) {
        List<Competition> competitions = competitionsDAO.findAll();
        model.addAttribute("competitions", competitions);

        return "show-competitions";
    }
}