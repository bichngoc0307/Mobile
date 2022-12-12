package com.bmt.lab4.entity;

import java.util.List;

public class Officials {
    private String name;
    private List<Address> address;
    private String party;
    private List<String> phones;
    private List<String> urls;
    private List<String> emails;
    private String photoUrl;
    private List<Channel> channels;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    @Override
    public String toString() {
        return "Officials{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", party='" + party + '\'' +
                ", phones=" + phones +
                ", urls=" + urls +
                ", emails=" + emails +
                ", photoUrl='" + photoUrl + '\'' +
                ", channels=" + channels +
                '}';
    }
}
