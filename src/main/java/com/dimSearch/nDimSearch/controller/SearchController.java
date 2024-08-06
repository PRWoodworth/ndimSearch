package com.dimSearch.nDimSearch.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.dimSearch.nDimSearch.service.NDimSearchService;

import java.util.ArrayList;

@RestController
class SearchController {
    private static final Logger log = LogManager.getLogger(SearchController.class.getName());

    @Autowired
    NDimSearchService nDimSearchService;

    @GetMapping("/search")
    public void searchEndpoint(){

    }

    
}
