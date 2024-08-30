package com.dimSearch.nDimSearch.service;

import com.dimSearch.nDimSearch.data.DataHolder;
import com.dimSearch.nDimSearch.data.SplitInputHolder;
import com.dimSearch.nDimSearch.data.SplitOffsetHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


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
        ResponseEntity<String> searchResponseEntity = new ResponseEntity<>("Target not found.", HttpStatus.OK);
        try{
            SplitOffsetHolder offsetHolder = search(searchTarget, input, 0, 0);
            int originalIndex = splitOffsetBacktrack(offsetHolder, input.size());
            searchResponseEntity = new ResponseEntity<>("Target found at index ".concat(String.valueOf(originalIndex)), HttpStatus.OK);
        } catch (Exception e){
            searchResponseEntity = new ResponseEntity<>("Error occurred during search.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return searchResponseEntity;
    }

    public SplitOffsetHolder search(String searchTarget, List<DataHolder> input, int upperSplitOffset, int lowerSplitOffset) {
        log.info("Input: {}", input.toString());
        log.info("Upper split offset: {}", upperSplitOffset);
        log.info("Lower split offset: {}", lowerSplitOffset);

        if (input.size() > 1) {
            SplitInputHolder splitInput = split(input);
            log.info("Split Input: {}", splitInput.toString());
//            TODO: calculate offset from original split based on number of upper/lower splits

            search(searchTarget, splitInput.getUpperHalf(), upperSplitOffset + 1, lowerSplitOffset);
            search(searchTarget, splitInput.getLowerHalf(),  upperSplitOffset, lowerSplitOffset + 1);
        } else {
            if (input.get(0).getName().equalsIgnoreCase(searchTarget)) {
                return new SplitOffsetHolder(upperSplitOffset, lowerSplitOffset);
            }
        }
        return null;
    }

    public int splitOffsetBacktrack(SplitOffsetHolder offsetHolder, int originalSize){
        return 0;
    }
}

