package com.github.hm.api.beans.domain;

import java.util.List;

public class Hotel {
    private String name;
    private String phone;
    private List<PointOfInterest> pointOfInterests;
    private List<Room> rooms;
    private HotelAddress address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PointOfInterest> getPointOfInterests() {
        return pointOfInterests;
    }

    public void setPointOfInterests(List<PointOfInterest> pointOfInterests) {
        this.pointOfInterests = pointOfInterests;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public HotelAddress getAddress() {
        return address;
    }

    public void setAddress(HotelAddress address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}