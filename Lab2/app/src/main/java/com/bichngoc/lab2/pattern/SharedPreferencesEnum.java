package com.bichngoc.lab2.pattern;



public enum SharedPreferencesEnum {
    KEY("notes"),SHAREDPREFERENCESNAME("shared preferences");

    private String value;
    private SharedPreferencesEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
