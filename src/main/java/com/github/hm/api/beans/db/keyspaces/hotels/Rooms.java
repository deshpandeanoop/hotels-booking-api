package com.github.hm.api.beans.db.keyspaces.hotels;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;

@Table
public class Rooms {
    private int roomNumber;
    private int price;
    @CassandraType(type = DataType.Name.TUPLE)
    private List<AmenityTuple> amenities;
    @PrimaryKey
    private String hotelName;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<AmenityTuple> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<AmenityTuple> amenities) {
        this.amenities = amenities;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}