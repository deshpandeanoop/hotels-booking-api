package com.github.hm.api.beans.domain;

public class HotelAddress {
    private String city;
    private String state;
    private String country;
    private String zipCode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public static com.github.hm.api.beans.db.keyspaces.hotels.HotelAddress cloneUDT(HotelAddress hotelAddress){
        com.github.hm.api.beans.db.keyspaces.hotels.HotelAddress hotelAddressUDT = new com.github.hm.api.beans.db.keyspaces.hotels.HotelAddress();
        hotelAddressUDT.setCity(hotelAddress.getCity());
        hotelAddressUDT.setState(hotelAddress.getState());
        hotelAddressUDT.setCountry(hotelAddress.getCountry());
        hotelAddressUDT.setZipCode(hotelAddress.getZipCode());

        return hotelAddressUDT;
    }
}