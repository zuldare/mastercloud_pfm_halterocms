package com.pfm.halterocms.controllers.competitionPlay;

import com.pfm.halterocms.daos.WeighinsDAO;
import com.pfm.halterocms.models.Weighin;

public class IntroduceWeighinDataController {

    private final WeighinsDAO weighinsDAO;

    public IntroduceWeighinDataController(WeighinsDAO weighinsDAO) {
        this.weighinsDAO = weighinsDAO;
    }

    public String addWeighin(Weighin weighin) {
        weighinsDAO.save(weighin);
        return "redirect:/competition-secretary-play";
    }


}
