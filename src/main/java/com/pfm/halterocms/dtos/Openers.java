package com.pfm.halterocms.dtos;

public class Openers {

    private Double bodyWeight;

    private Integer snatchOpener;

    private Integer cleanAndJerkOpener;

    public Openers(WeighinDataDto weighinDataDto) throws NumberFormatException {
        this.bodyWeight = this.getDoubleValueOrNullIfBlank(weighinDataDto.getBodyWeight());
        this.snatchOpener = this.getIntegerValueOrNullIfBlank(weighinDataDto.getSnatchOpener());
        this.cleanAndJerkOpener = this.getIntegerValueOrNullIfBlank(weighinDataDto.getCleanAndJerkOpener());
    }

    private Double getDoubleValueOrNullIfBlank(String value){
        return value.isBlank() ? null : Double.valueOf(value);
    }

    private Integer getIntegerValueOrNullIfBlank(String value){
        return value.isBlank() ? null : Integer.valueOf(value);
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
}
