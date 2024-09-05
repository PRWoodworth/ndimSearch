package com.dimSearch.nDimSearch.controller;

import com.dimSearch.nDimSearch.data.POJO.InputData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.dimSearch.nDimSearch.service.NDimSearchService;


@RestController
public class SearchController {
    private static final Logger log = LogManager.getLogger(SearchController.class.getName());

    @Autowired NDimSearchService searchService;

    @RequestMapping(value = "/search", method= RequestMethod.GET)
    public ResponseEntity searchEndpoint(@RequestBody InputData requestBody){
        log.info("INCOMING REQUEST: {}", requestBody.toString());
        return searchService.searchOperation(requestBody.getSearchTarget(), requestBody.getInput());
    }

    
}
