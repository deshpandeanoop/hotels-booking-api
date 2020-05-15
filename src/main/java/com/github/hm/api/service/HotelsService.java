package com.github.hm.api.service;

import com.github.hm.api.beans.request.UploadHotelsRequestBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HotelsService implements IHotelsService{
    private static final Logger LOGGER = LoggerFactory.getLogger(HotelsService.class);

    @Override
    public void add(UploadHotelsRequestBean uploadHotelsRequestBean) {
        LOGGER.info("Processing request Add Hotels request");
    }
}
