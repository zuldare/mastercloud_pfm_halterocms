package com.pfm.halterocms.unit.models;

import com.pfm.halterocms.models.Competition;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CompetitionTest {

    @Test
    public void whenInitCompetionShouldSetAttributesProperly() {
        Integer competitionId = 1;
        String competitionName = "name";
        String competitionType = "junior";

        String location = "location";
        String organizer = "organizer";

        LocalDate inscriptionStartDate = LocalDate.of(2022, Month.APRIL, 20);
        LocalDate inscriptionEndDate = LocalDate.of(2022, Month.APRIL, 22);

        LocalDate startDate = LocalDate.of(2022, Month.APRIL, 23);
        LocalDate endDate = LocalDate.of(2022, Month.APRIL, 25);

        Competition competitionToVerify = new Competition(competitionId,
                competitionName, competitionType,
                location, organizer,
                inscriptionStartDate, inscriptionEndDate,
                startDate, endDate);

        assertThat(competitionToVerify.getId(), is(competitionId));
        assertThat(competitionToVerify.getName(), is(competitionName));
        assertThat(competitionToVerify.getType(), is(competitionType));

        assertThat(competitionToVerify.getLocation(), is(location));
        assertThat(competitionToVerify.getOrganizer(), is(organizer));

        assertThat(competitionToVerify.getInscriptionStartDate(), is(inscriptionStartDate));
        assertThat(competitionToVerify.getInscriptionEndDate(), is(inscriptionEndDate));

        assertThat(competitionToVerify.getStartDate(), is(startDate));
        assertThat(competitionToVerify.getEndDate(), is(endDate));
    }
}
