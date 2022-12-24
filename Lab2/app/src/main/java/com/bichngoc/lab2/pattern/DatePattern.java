package com.bichngoc.lab2.pattern;


public enum DatePattern {
    DATE_TIME("dd-M-yyyy hh:mm:ss");

    private String value;

    DatePattern() {
    }

    private DatePattern(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
