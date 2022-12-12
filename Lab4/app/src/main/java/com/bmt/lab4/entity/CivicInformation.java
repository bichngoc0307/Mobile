package com.bmt.lab4.entity;

import java.util.List;

public class CivicInformation {
    private String kind;
    private NormalizedInput normalizedInput;
    private List<Offices> offices;
    private List<Officials> officials;


    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public NormalizedInput getNormalizedInput() {
        return normalizedInput;
    }

    public void setNormalizedInput(NormalizedInput normalizedInput) {
        this.normalizedInput = normalizedInput;
    }


    public List<Offices> getOffices() {
        return offices;
    }

    public void setOffices(List<Offices> offices) {
        this.offices = offices;
    }

    public List<Officials> getOfficials() {
        return officials;
    }

    public void setOfficials(List<Officials> officials) {
        this.officials = officials;
    }

    @Override
    public String toString() {
        return "CivicInformation{" +
                "kind='" + kind + '\'' +
                ", normalizedInput=" + normalizedInput +
                ", offices=" + offices +
                ", officials=" + officials +
                '}';
    }
}
