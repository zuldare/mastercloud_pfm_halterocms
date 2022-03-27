package com.pfm.halterocms.unit.models;

import com.pfm.halterocms.models.Batch;
import com.pfm.halterocms.models.Competition;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BatchTest {

    @Test
    public void whenInitBatchShouldSetAttributesProperly() {
        Integer batchId = 1;
        Competition competition = new Competition();

        String platform = "platform";
        String gender = "gender";

        LocalDate date = LocalDate.of(2022, Month.APRIL, 20);
        LocalTime weighinTime = LocalTime.of(10, 0);
        LocalTime startTime = LocalTime.of(12, 0);

        Batch batchToVerify = new Batch(
                batchId, competition,
                platform, gender,
                date, weighinTime, startTime);

        assertThat(batchToVerify.getId(), is(batchId));
        assertThat(batchToVerify.getCompetition(), is(competition));

        assertThat(batchToVerify.getPlatform(), is(platform));
        assertThat(batchToVerify.getGender(), is(gender));

        assertThat(batchToVerify.getDate(), is(date));
        assertThat(batchToVerify.getWeighinTime(), is(weighinTime));
        assertThat(batchToVerify.getStartTime(), is(startTime));


    }
}
