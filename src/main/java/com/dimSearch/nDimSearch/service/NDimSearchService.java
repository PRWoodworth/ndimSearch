package com.dimSearch.nDimSearch.service;

import com.dimSearch.nDimSearch.data.DataHolder;
import com.dimSearch.nDimSearch.data.SplitInputHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;


@Service
public class NDimSearchService {
    private static final Logger log = LogManager.getLogger(NDimSearchService.class.getName());

//        TODO: implement basic recursive half/half search first on unsorted 1d array
//        TODO: expand to 2d search
//        TODO: create thread for each recursive (one for upper half, one for lower half)?
//        TODO: generalize to n-d

//    TODO: recursively flatten each level until single flat array?

    public SplitInputHolder split(List<DataHolder> input){
        return new SplitInputHolder(input.subList(0, input.size()/2), input.subList((input.size()/2), input.size()));
    }

    public Deque<Character> updateAndReturn(Deque<Character> offsetQueue, char charToAdd){
        offsetQueue.addFirst(charToAdd);
        return offsetQueue;
    }

    //TODO: return list of all locations where the target was found?
    public ResponseEntity<String> searchOperation(String searchTarget, List<DataHolder> input){
        ResponseEntity<String> searchResponseEntity = new ResponseEntity<>("REQUEST_TEMPLATE", HttpStatus.ACCEPTED);
        try{
            int originalSize = input.size();
            log.info("Input size: {}", originalSize);
            int originalIndex = search(searchTarget, input, input.size()/2);
            switch(originalIndex){
                case -1: return new ResponseEntity<>("Target not found within given input ", HttpStatus.OK);
                default: return new ResponseEntity<>("Target found at index ".concat(String.valueOf(originalIndex)), HttpStatus.OK);
            }
        } catch (Exception e){
            return new ResponseEntity<>("Error occurred during search.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public int search(String searchTarget, List<DataHolder> input, int midIndex) {
        log.info("Input: {}", input.toString());
        log.info("Mid Index: {}", String.valueOf(midIndex));

        if (input.size() > 1) {
            SplitInputHolder splitInput = split(input);
            log.info("Split Input: {}", splitInput.toString());
            search(searchTarget, splitInput.getUpperHalf(), (int) (midIndex + Math.ceil(splitInput.getUpperHalf().size()) / 2));
            search(searchTarget, splitInput.getLowerHalf(), (int) (midIndex - Math.floor(splitInput.getLowerHalf().size()) / 2));
        } else {
            if (input.get(0).getName().equalsIgnoreCase(searchTarget)) {
                log.info("Search target found at {}", midIndex);
                return midIndex;
                //TODO: finds value correctly but later returns override the value
            }
        }
        return -1;
    }
}

