package com.pfm.halterocms.controllers.competitionPlay;

import com.pfm.halterocms.daos.BatchLiftersDAO;
import com.pfm.halterocms.daos.WeighinsDAO;
import com.pfm.halterocms.dtos.Openers;
import com.pfm.halterocms.dtos.WeighinDataDto;
import com.pfm.halterocms.models.BatchLifter;
import com.pfm.halterocms.models.Weighin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Controller
public class CompetitionSecretaryPlayController {

    private static final String ERROR_COMPETITION_SECRETARY_PLAY_ERROR = "/error/competition-secreatary-play-error";
    private static final String SHOW_COMPETITION_PLAY_OK = "show-competition-play";

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

        return SHOW_COMPETITION_PLAY_OK;
    }


    @PostMapping("/introduce-weighin-data")
    public String introduceWeighinData(Model model, @ModelAttribute("weighinDataDto") WeighinDataDto weighinDataDto) {

        Openers openers;
        try {
            openers = new Openers(weighinDataDto);
        } catch (NumberFormatException e){
            return getErrorPath(model, weighinDataDto);
        }

        if (checkIfOpenersAreWrong(openers)){
            return getErrorPath(model, weighinDataDto);
        }

        saveBatchLifterWeighIn(weighinDataDto, openers);

        return "redirect:/" + SHOW_COMPETITION_PLAY_OK + "/" + weighinDataDto.getBatchId();
    }

    private String getErrorPath(Model model, WeighinDataDto weighinDataDto) {
        model.addAttribute("batchId", weighinDataDto.getBatchId());
        return ERROR_COMPETITION_SECRETARY_PLAY_ERROR;
    }

    private void saveBatchLifterWeighIn(WeighinDataDto weighinDataDto, Openers openers) {
        BatchLifter batchLifter = batchLiftersDAO
                .findOneByBatchIdAndDrawOrder(weighinDataDto.getBatchId(), weighinDataDto.getDrawOrder());

        Weighin weighin = getWeighin(openers, batchLifter);

        Weighin savedWeighin = weighinsDAO.save(weighin);

        batchLifter.setWeighin(savedWeighin);

        batchLiftersDAO.save(batchLifter);
    }

    private Weighin getWeighin(Openers openers, BatchLifter batchLifter) {
        Weighin weighin = new Weighin(
                batchLifter.getWeighin().getId(),
                batchLifter.getLifter(),
                openers.getBodyWeight(),
                openers.getSnatchOpener(),
                openers.getCleanAndJerkOpener(),
                LocalTime.now()
        );
        return weighin;
    }

    private boolean checkIfOpenersAreWrong(Openers openers) {
        return lessThanZeroAndNotNull(openers.getBodyWeight())
                || lessThanZeroAndNotNull(openers.getSnatchOpener())
                || lessThanZeroAndNotNull(openers.getCleanAndJerkOpener());
    }

    private Boolean lessThanZeroAndNotNull(Double value){
        return Objects.nonNull(value) && value <= 0;
    }

    private Boolean lessThanZeroAndNotNull(Integer value){
        return Objects.nonNull(value) && value <= 0;
    }

}
