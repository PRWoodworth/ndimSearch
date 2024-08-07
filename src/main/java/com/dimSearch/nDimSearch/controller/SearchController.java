package com.dimSearch.nDimSearch.controller;

import com.dimSearch.nDimSearch.data.POJO.InputData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.dimSearch.nDimSearch.service.NDimSearchService;


@RestController
class SearchController {
    private static final Logger log = LogManager.getLogger(SearchController.class.getName());

    @Autowired NDimSearchService searchService;

    @GetMapping("/search")
    public void searchEndpoint(@RequestBody InputData requestBody){
        searchService.search(requestBody.getSearchTarget(), requestBody.getInput());
    }

    
}
