package com.pfm.halterocms.unit.models;

import com.pfm.halterocms.models.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class BatchLifterTest {

    @Test
    public void whenInitBatchLifterShouldSetAttributesProperly() {
        Integer batchLifterId = 1;
        Integer drawOrder = 4;
        List<Lift> lifts = new ArrayList<>();

        Batch batch = mock(Batch.class);
        Lifter lifter = mock(Lifter.class);
        Weighin weighin = mock(Weighin.class);

        BatchLifter batchLifterToVerify = new BatchLifter(
                batchLifterId, drawOrder,
                batch, lifter, weighin, lifts);

        assertThat(batchLifterToVerify.getId(), is(batchLifterId));
        assertThat(batchLifterToVerify.getDrawOrder(), is(drawOrder));

        assertThat(batchLifterToVerify.getBatch(), is(batch));
        assertThat(batchLifterToVerify.getLifter(), is(lifter));
        assertThat(batchLifterToVerify.getWeighin(), is(weighin));
        assertNotNull(batchLifterToVerify.getLifts());
        assertThat(batchLifterToVerify.getLifts().size(), is(0));
    }


    @Test
    public void whenInitBatchLifterShouldSetAttributesProperlyFullfillingLifts() {
        Integer batchLifterId = 1;
        Integer drawOrder = 4;
        List<Lift> lifts = new ArrayList<>();

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
        assertNotNull(batchLifterToVerify.getLifts());
        assertThat(batchLifterToVerify.getLifts().size(), is(6));


        for(int i=0; i<6; i++){
            assertThat(batchLifterToVerify.getLifts().get(i).getBatchLifterId(), is(batchLifterId));
            assertThat(batchLifterToVerify.getLifts().get(i).getStatus(), is(LiftStatus.PENDING.getValue()));

            if (i<3) {
                assertThat(batchLifterToVerify.getLifts().get(i).getType(), is(LiftType.SNATCH.getValue()));
            } else {
                assertThat(batchLifterToVerify.getLifts().get(i).getType(), is(LiftType.CLEAN_AND_JERK.getValue()));
            }

        }


    }
}
