package com.github.hm.api.controller;

import com.github.hm.api.beans.request.UploadHotelsRequestBean;
import com.github.hm.api.service.IHotelsService;
import com.github.hm.api.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/hotels")
public class HotelsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HotelsController.class);
    private final IHotelsService hotelsService;

    public HotelsController(IHotelsService hotelsService) {
        this.hotelsService = hotelsService;
    }

    @PostMapping
    public void addHotels(@RequestBody UploadHotelsRequestBean uploadHotelsRequestBean){
        Optional<String> requestToJsonOptional = JsonUtils.toJsonString(uploadHotelsRequestBean);
        requestToJsonOptional.ifPresent(requestJson -> LOGGER.info("Received add hotels request {}", requestJson));

        hotelsService.add(uploadHotelsRequestBean);
    }
}