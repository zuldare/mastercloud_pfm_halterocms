package com.pfm.halterocms.unit.models;

import com.pfm.halterocms.models.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

public class BatchLifterTest {

    @Test
    public void whenInitBatchLifterShouldSetAttributesProperly() {
        Integer batchLifterId = 1;
        Integer drawOrder = 4;

        Batch batch = mock(Batch.class);
        Lifter lifter = mock(Lifter.class);
        Weighin weighin = mock(Weighin.class);

        BatchLifter batchLifterToVerify = new BatchLifter(
                batchLifterId, drawOrder,
                batch, lifter, weighin);

        assertThat(batchLifterToVerify.getId(), is(batchLifterId));
        assertThat(batchLifterToVerify.getDrawOrder(), is(drawOrder));

        assertThat(batchLifterToVerify.getBatch(), is(batch));
        assertThat(batchLifterToVerify.getLifter(), is(lifter));
        assertThat(batchLifterToVerify.getWeighin(), is(weighin));
    }
}
