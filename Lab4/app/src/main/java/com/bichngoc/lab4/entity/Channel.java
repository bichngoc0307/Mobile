package com.bichngoc.lab4.entity;

public class Channel {
    private String type;
    private String id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
