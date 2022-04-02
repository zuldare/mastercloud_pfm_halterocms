package com.pfm.halterocms.dtos;

import java.time.LocalTime;

public class WeighinDataDto {

    private Integer batchId;

    private Integer drawOrder;

    private Double bodyWeight;

    private Integer snatchOpener;

    private Integer cleanAndJerkOpener;

    private LocalTime time;

    public WeighinDataDto(){}

    public WeighinDataDto(Integer batchId, Integer drawOrder,
                          Double bodyWeight,
                          Integer snatchOpener, Integer cleanAndJerkOpener) {
        this.batchId = batchId;
        this.drawOrder = drawOrder;
        this.bodyWeight = bodyWeight;
        this.snatchOpener = snatchOpener;
        this.cleanAndJerkOpener = cleanAndJerkOpener;
        this.time = LocalTime.now();
    }

    public Integer getBatchId() {
        return batchId;
    }

    public Integer getDrawOrder() {
        return drawOrder;
    }

    public Double getBodyWeight() {
        return bodyWeight;
    }

    public Integer getSnatchOpener() {
        return snatchOpener;
    }

    public Integer getCleanAndJerkOpener() {
        return cleanAndJerkOpener;
    }

    public LocalTime getTime() {
        return time;
    }
}
