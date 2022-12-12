package com.bmt.lab4.dto;

import java.io.Serializable;

public class President implements Serializable {
    private String role;
    private String name;
    private String party;
    public President(){}
    public President(String role, String name, String party) {
        this.role = role;
        this.name = name;
        this.party = party;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }
}
