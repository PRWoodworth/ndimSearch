package com.dimSearch.nDimSearch.service;

import com.dimSearch.nDimSearch.data.DataHolder;
import com.dimSearch.nDimSearch.data.SplitInputHolder;
import com.dimSearch.nDimSearch.data.OffsetData;
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

    //TODO: return list of all locations where the target was found?
    public ResponseEntity<String> searchOperation(String searchTarget, List<DataHolder> input){
        ResponseEntity<String> searchResponseEntity;
        Deque<Character> offsetDeque = new ArrayDeque<>();
        try{
            OffsetData offsetHolder = search(searchTarget, input, offsetDeque, 0, 0);
            int originalIndex = splitOffsetBacktrack(offsetHolder, input.size());
            searchResponseEntity = new ResponseEntity<>("Target found at index ".concat(String.valueOf(originalIndex)), HttpStatus.OK);
        } catch (Exception e){
            searchResponseEntity = new ResponseEntity<>("Error occurred during search.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return searchResponseEntity;
    }

    public OffsetData search(String searchTarget, List<DataHolder> input, Deque<Character> offsetQueue, int upperOffset, int lowerOffset) {
        log.info("Input: {}", input.toString());
        log.info("Upper split offset: {}", upperOffset);
        log.info("Lower split offset: {}", lowerOffset);

        if (input.size() > 1) {
            SplitInputHolder splitInput = split(input);
            log.info("Split Input: {}", splitInput.toString());
            search(searchTarget, splitInput.getUpperHalf(), offsetQueue.addFirst('U'), upperOffset + 1, lowerOffset);
            search(searchTarget, splitInput.getLowerHalf(), offsetQueue.addFirst('L'), upperOffset, lowerOffset + 1);
        } else {
            if (input.get(0).getName().equalsIgnoreCase(searchTarget)) {
                return new OffsetData(upperOffset, lowerOffset, offsetQueue);
            }
        }
        return null;
    }

    public int splitOffsetBacktrack(OffsetData offsetHolder, int originalSize){
//      TODO: calculate offset from original split based on number of upper/lower splits and original size
        /*
        determine how far to move from center
        move direction up/down # of times equal to offset counts
         */
        int totalOffsets = offsetHolder.getLowerSplitOffset() + offsetHolder.getUpperSplitOffset();
        int sizeHolder = originalSize;
        int index = sizeHolder/2;
        int offsetMove = 0;
        Deque offsetDeque = offsetHolder.getOffsetDirections();
        char offsetDirection;
        for (int i = 0; i < totalOffsets; i++) {
            offsetMove = sizeHolder/2;
            offsetDirection = offsetHolder.getOffsetDirections().pop().toString().charAt(0);
            sizeHolder /= 2;
        }
        return 0;
    }
}

