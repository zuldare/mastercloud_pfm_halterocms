package com.pfm.halterocms.controllers.competitionPlay;

import com.pfm.halterocms.daos.BatchLiftersDAO;
import com.pfm.halterocms.daos.WeighinsDAO;
import com.pfm.halterocms.dtos.WeighinDataDto;
import com.pfm.halterocms.models.BatchLifter;
import com.pfm.halterocms.models.Weighin;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class CompetitionSecretaryPlayController {

    private final BatchLiftersDAO batchLiftersDAO;

    private final WeighinsDAO weighinsDAO;

    public CompetitionSecretaryPlayController(BatchLiftersDAO batchLiftersDAO, WeighinsDAO weighinsDAO) {
        this.batchLiftersDAO = batchLiftersDAO;
        this.weighinsDAO = weighinsDAO;
    }

    @GetMapping("/show-competition-play/{batchId}")
    public String getBatchLifters(@PathVariable("batchId") Integer batchId, Model model) {

        List<BatchLifter> batchLifters = batchLiftersDAO.findAllByBatchId(batchId);

        model.addAttribute("batchLifters", batchLifters);

        if (batchLifters.size() > 0) {
            model.addAttribute("batch", batchLifters.get(0).getBatch());
        }

        return "show-competition-play";
    }

    @PostMapping("/introduce-weighin-data")
    public String introduceWeighinData(@ModelAttribute WeighinDataDto weighinDataDto) {

        BatchLifter batchLifter = batchLiftersDAO.findOneByBatchIdAndDrawOrder(
                weighinDataDto.getBatchId(), weighinDataDto.getDrawOrder()
        );

        Weighin weighin = new Weighin(
                batchLifter.getLifter(),
                weighinDataDto.getBodyWeight(),
                weighinDataDto.getSnatchOpener(),
                weighinDataDto.getCleanAndJerkOpener(),
                weighinDataDto.getTime()
        );

        Weighin savedWeighin = weighinsDAO.save(weighin);
        batchLifter.setWeighin(savedWeighin);
        batchLiftersDAO.save(batchLifter);

        return "redirect:/show-competition-play/" + weighinDataDto.getBatchId();
    }

}
