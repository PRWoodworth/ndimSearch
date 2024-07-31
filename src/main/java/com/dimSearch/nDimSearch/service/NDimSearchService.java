package com.dimSearch.nDimSearch.service;

import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
class NDimSearchService {
    private static final Logger log = LogManager.getLogger(WorldGenerationService.class.getName());

    public void splitInput(){
        //TODO: split input in half
    }

    public void checkInput(){
        //TODO: if input is list/array/etc., split 
        //TODO: recursive until atomic element found
    }
      
}
