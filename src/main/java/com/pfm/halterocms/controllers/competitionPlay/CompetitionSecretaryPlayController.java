package com.pfm.halterocms.controllers.competitionPlay;

import com.pfm.halterocms.daos.BatchLiftersDAO;
import com.pfm.halterocms.daos.WeighinsDAO;
import com.pfm.halterocms.dtos.WeighinDataDto;
import com.pfm.halterocms.models.BatchLifter;
import com.pfm.halterocms.models.Weighin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@Controller
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
    public String introduceWeighinData(Model model, @ModelAttribute("weighinDataDto") WeighinDataDto weighinDataDto) {

        BatchLifter batchLifter = batchLiftersDAO.findOneByBatchIdAndDrawOrder(
                weighinDataDto.getBatchId(), weighinDataDto.getDrawOrder()
        );

        Double bodyWeight;
        Integer snatchOpener;
        Integer cleanAndJerkOpener;

        try {
            bodyWeight = weighinDataDto.getBodyWeight().isBlank()
                    ? null : Double.valueOf(weighinDataDto.getBodyWeight());

            snatchOpener = weighinDataDto.getSnatchOpener().isBlank()
                    ? null : Integer.valueOf(weighinDataDto.getSnatchOpener());

            cleanAndJerkOpener = weighinDataDto.getCleanAndJerkOpener().isBlank()
                    ? null : Integer.valueOf(weighinDataDto.getCleanAndJerkOpener());

        } catch (NumberFormatException e) {
            model.addAttribute("batchId", weighinDataDto.getBatchId());
            return "/error/competition-secreatary-play-error";
        }

        Weighin weighin = new Weighin(
                batchLifter.getWeighin().getId(),
                batchLifter.getLifter(),
                bodyWeight,
                snatchOpener,
                cleanAndJerkOpener,
                LocalTime.now()
        );

        Weighin savedWeighin = weighinsDAO.save(weighin);
        batchLifter.setWeighin(savedWeighin);
        batchLiftersDAO.save(batchLifter);

        return "redirect:/show-competition-play/" + weighinDataDto.getBatchId();
    }

}
