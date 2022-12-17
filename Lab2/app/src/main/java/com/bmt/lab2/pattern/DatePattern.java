package com.bmt.lab2.pattern;

import lombok.Getter;

public enum DatePattern {
    DATE_TIME("dd-M-yyyy hh:mm:ss");

    public String getValue() {
        return value;
    }

    private String value;
    private DatePattern(String value){
        this.value = value;
    }
}
