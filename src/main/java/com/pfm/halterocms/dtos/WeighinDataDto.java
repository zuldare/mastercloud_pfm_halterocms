package com.pfm.halterocms.dtos;

import java.time.LocalTime;

public class WeighinDataDto {

    private Integer batchId;

    private Integer drawOrder;

    private String bodyWeight;

    private String snatchOpener;

    private String cleanAndJerkOpener;

    private LocalTime time;

    public WeighinDataDto(){}

    public WeighinDataDto(Integer batchId, Integer drawOrder,
                          String bodyWeight,
                          String snatchOpener, String cleanAndJerkOpener) {
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

    public String getBodyWeight() {
        return bodyWeight;
    }

    public String getSnatchOpener() {
        return snatchOpener;
    }

    public String getCleanAndJerkOpener() {
        return cleanAndJerkOpener;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public void setDrawOrder(Integer drawOrder) {
        this.drawOrder = drawOrder;
    }

    public void setBodyWeight(String bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public void setSnatchOpener(String snatchOpener) {
        this.snatchOpener = snatchOpener;
    }

    public void setCleanAndJerkOpener(String cleanAndJerkOpener) {
        this.cleanAndJerkOpener = cleanAndJerkOpener;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
