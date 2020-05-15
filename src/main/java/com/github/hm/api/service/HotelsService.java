package com.github.hm.api.service;

import com.github.hm.api.beans.request.UploadHotelsRequestBean;
import com.github.hm.api.builders.HotelsColumnsFamilyBuilder;
import com.github.hm.api.repository.hotels.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelsService implements IHotelsService{
    private static final Logger LOGGER = LoggerFactory.getLogger(HotelsService.class);
    private final HotelsColumnsFamilyBuilder columnsFamilyBuilder = HotelsColumnsFamilyBuilder.getInstance();
    private PoiByHotelRepository poiByHotelRepository;
    private HotelsByNameRepository hotelsByNameRepository;
    private HotelsByPoiRepository hotelsByPoiRepository;
    private RoomsAvailabilityRepository roomsAvailabilityRepository;
    private RoomsRepository roomsRepository;

    @Override
    public void add(UploadHotelsRequestBean uploadHotelsRequestBean) {
        LOGGER.info("Processing request Add Hotels request");

        poiByHotelRepository.saveAll(columnsFamilyBuilder.buildPoiByHotel(uploadHotelsRequestBean));
        LOGGER.info("Populated PoiByHotels column family");

        hotelsByNameRepository.saveAll(columnsFamilyBuilder.buildHotelsByName(uploadHotelsRequestBean));
        LOGGER.info("Populated HotelsByName column family");

        hotelsByPoiRepository.saveAll(columnsFamilyBuilder.buildHotelsByPoiFamily(uploadHotelsRequestBean));
        LOGGER.info("Populated HotelsByPoi column family");

        roomsAvailabilityRepository.saveAll(columnsFamilyBuilder.buildRoomsAvailability(uploadHotelsRequestBean));
        LOGGER.info("Populated RoomsAvailability column family");

        roomsRepository.saveAll(columnsFamilyBuilder.buildRooms(uploadHotelsRequestBean));
        LOGGER.info("Populated Rooms column family");

        LOGGER.info("Add hotels request processed successfully");
    }

    @Autowired
    public void setPoiByHotelRepository(PoiByHotelRepository poiByHotelRepository) {
        this.poiByHotelRepository = poiByHotelRepository;
    }

    @Autowired
    public void setHotelsByNameRepository(HotelsByNameRepository hotelsByNameRepository) {
        this.hotelsByNameRepository = hotelsByNameRepository;
    }

    @Autowired
    public void setHotelsByPoiRepository(HotelsByPoiRepository hotelsByPoiRepository) {
        this.hotelsByPoiRepository = hotelsByPoiRepository;
    }

    @Autowired
    public void setRoomsAvailabilityRepository(RoomsAvailabilityRepository roomsAvailabilityRepository) {
        this.roomsAvailabilityRepository = roomsAvailabilityRepository;
    }

    @Autowired
    public void setRoomsRepository(RoomsRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }
}