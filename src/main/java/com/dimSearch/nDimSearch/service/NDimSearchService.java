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

//        TODO: expand to 2d search
//        TODO: create thread for each recursive (one for upper half, one for lower half)?
//        TODO: generalize to n-d

    public SplitInputHolder split(List<DataHolder> input){
        return new SplitInputHolder(input.subList(0, input.size()/2), input.subList((input.size()/2), input.size()));
    }

    public ResponseEntity<String> searchOperation(String searchTarget, List<DataHolder> input){
        try{
            ArrayList<Integer> positiveSearchReturns = search(searchTarget, input, input.size()/2, new ArrayList<>());
            return new ResponseEntity<>(positiveSearchReturns.toString(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Error occurred during search.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ArrayList<Integer> search(String searchTarget, List<DataHolder> input, int midIndex, ArrayList<Integer> positiveReturns) {
        if (input.size() > 1) {
            SplitInputHolder splitInput = split(input);
            search(searchTarget, splitInput.getUpperHalf(), (int) (midIndex + Math.ceil(splitInput.getUpperHalf().size()) / 2), positiveReturns);
            search(searchTarget, splitInput.getLowerHalf(), (int) (midIndex - Math.floor(splitInput.getLowerHalf().size()) / 2), positiveReturns);
        } else {
            if (input.get(0).getName().equalsIgnoreCase(searchTarget)) {
                positiveReturns.add(midIndex);
            }
        }
        return positiveReturns;
    }
}

