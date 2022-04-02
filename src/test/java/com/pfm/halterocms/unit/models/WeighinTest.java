package com.pfm.halterocms.unit.models;

import com.pfm.halterocms.models.Lifter;
import com.pfm.halterocms.models.Weighin;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WeighinTest {

    @Test
    public void whenInitWeighinShouldSetAttributesProperly() {
        Integer weighinId = 1;
        Lifter lifter = new Lifter();

        Double bodyWeight = 108.56;
        Integer snatchOpener = 95;
        Integer cleanAndJerkOpener = 85;

        LocalTime time = LocalTime.of(10, 53);

        Weighin weighinToVerify = new Weighin(
                weighinId, lifter, bodyWeight,
                snatchOpener, cleanAndJerkOpener,
                time);

        assertThat(weighinToVerify.getId(), is(weighinId));
        assertThat(weighinToVerify.getTime(), is(time));

        assertThat(weighinToVerify.getLifter(), is(lifter));
        assertThat(weighinToVerify.getBodyWeight(), is(bodyWeight));

        assertThat(weighinToVerify.getSnatchOpener(), is(snatchOpener));
        assertThat(weighinToVerify.getCleanAndJerkOpener(), is(cleanAndJerkOpener));
    }
}
