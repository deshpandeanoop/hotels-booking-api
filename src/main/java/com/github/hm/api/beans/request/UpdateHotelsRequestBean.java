package com.github.hm.api.beans.request;

import com.github.hm.api.beans.domain.Hotel;

import java.util.List;

public class UpdateHotelsRequestBean {
    private int count;
    private List<Hotel> hotels;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }
}