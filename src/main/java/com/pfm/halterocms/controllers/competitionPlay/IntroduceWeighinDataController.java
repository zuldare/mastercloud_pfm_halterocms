package com.pfm.halterocms.controllers.competitionPlay;

import com.pfm.halterocms.daos.WeighinsDAO;
import com.pfm.halterocms.models.Weighin;
import org.springframework.web.bind.annotation.PostMapping;

public class IntroduceWeighinDataController {

    private final WeighinsDAO weighinsDAO;

    public IntroduceWeighinDataController(WeighinsDAO weighinsDAO) {
        this.weighinsDAO = weighinsDAO;
    }

    @PostMapping("/add-weighin")
    public String addWeighin(Weighin weighin) {

        weighinsDAO.save(weighin);

        Integer competitionId = weighin.getLifter().getCompetitionId();
        return "redirect:/show-inscribed-lifters/" + competitionId.toString();
    }

}
