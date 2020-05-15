package com.github.hm.api.builders;

import com.github.hm.api.beans.db.keyspaces.hotels.*;
import com.github.hm.api.beans.domain.Hotel;
import com.github.hm.api.beans.domain.HotelAddress;
import com.github.hm.api.beans.domain.PointOfInterest;
import com.github.hm.api.beans.request.UploadHotelsRequestBean;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public final class HotelsColumnsFamilyBuilder {
    private static final HotelsColumnsFamilyBuilder builder = new HotelsColumnsFamilyBuilder();

    private HotelsColumnsFamilyBuilder() {
    }

    public List<HotelsByPoi> buildHotelsByPoiFamily(UploadHotelsRequestBean uploadHotelsRequestBean) {
        return uploadHotelsRequestBean
                .getHotels()
                .stream()
                .map(hotel -> {
                    List<HotelsByPoi> hotelsByPoiList = new ArrayList<>();

                    if (!CollectionUtils.isEmpty(hotel.getPointOfInterests())) {
                        hotel.getPointOfInterests()
                                .forEach(pointOfInterest -> hotelsByPoiList.add(constructHotelsByPoi(hotel, pointOfInterest)));
                    }
                    return hotelsByPoiList;
                })
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private HotelsByPoi constructHotelsByPoi(Hotel hotel, PointOfInterest pointOfInterest) {
        HotelsByPoi hotelsByPoi = new HotelsByPoi();
        hotelsByPoi.setName(hotel.getName());
        hotelsByPoi.setPhone(hotel.getPhone());
        hotelsByPoi.setAddress(HotelAddress.cloneUDT(hotel.getAddress()));
        hotelsByPoi.setPoiName(pointOfInterest.getName());

        return hotelsByPoi;
    }

    public List<HotelsByName> buildHotelsByName(UploadHotelsRequestBean uploadHotelsRequestBean) {
        return uploadHotelsRequestBean.getHotels()
                .stream()
                .map(this::constructHotelsByName)
                .collect(Collectors.toList());
    }

    private HotelsByName constructHotelsByName(Hotel hotel) {
        HotelsByName hotelsByName = new HotelsByName();
        hotelsByName.setName(hotel.getName());
        hotelsByName.setPhone(hotel.getPhone());
        hotelsByName.setAddress(HotelAddress.cloneUDT(hotel.getAddress()));

        return hotelsByName;
    }

    public List<PoiByHotel> buildPoiByHotel(UploadHotelsRequestBean uploadHotelsRequestBean) {
        return uploadHotelsRequestBean
                .getHotels()
                .stream()
                .filter(hotel -> !CollectionUtils.isEmpty(hotel.getPointOfInterests()))
                .map(hotel -> {
                    List<PoiByHotel> poiByHotelList = new ArrayList<>();
                    hotel.getPointOfInterests()
                            .forEach(pointOfInterest -> poiByHotelList.add(constructPoiByHotel(hotel, pointOfInterest)));

                    return poiByHotelList;
                }).flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private PoiByHotel constructPoiByHotel(Hotel hotel, PointOfInterest pointOfInterest) {
        PoiByHotel poiByHotel = new PoiByHotel();
        poiByHotel.setName(pointOfInterest.getName());
        poiByHotel.setDescription(pointOfInterest.getDescription());
        poiByHotel.setHotelName(hotel.getName());

        return poiByHotel;
    }

    public List<RoomsAvailability> buildRoomsAvailability(UploadHotelsRequestBean uploadHotelsRequestBean) {
        return Collections.emptyList();
    }


    public List<Rooms> buildRooms(UploadHotelsRequestBean uploadHotelsRequestBean) {
        return Collections.emptyList();
    }

    public static HotelsColumnsFamilyBuilder getInstance() {
        return builder;
    }
}