package com.gadgetszan.mycattery.exception;

import com.gadgetszan.mycattery.service.OwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{
    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceNotFoundException.class);

    private static final long serialVersionUID = 1L;
    public ResourceNotFoundException(String message){
        super(message);
        LOGGER.error("Resource Not Found " + message);
    }
}