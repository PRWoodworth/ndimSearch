package com.dimSearch.nDimSearch.service;

import com.dimSearch.nDimSearch.data.DataHolder;
import com.dimSearch.nDimSearch.data.SplitInputHolder;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


@Service
public class NDimSearchService {
    private static final Logger log = LogManager.getLogger(NDimSearchService.class.getName());
    private List<Integer> locationArray = new ArrayList<Integer>();

//        TODO: implement basic recursive half/half search first on unsorted 1d array
//        TODO: expand to 2d search
//        TODO: create thread for each recursive (one for upper half, one for lower half)?
//        TODO: generalize to n-d

//    TODO: recursively flatten each level until single flat array?

    public SplitInputHolder split(List<DataHolder> input){
        return new SplitInputHolder(input.subList(0, input.size()/2), input.subList((input.size()/2), input.size()));
    }

    //TODO: return list of all locations where the target was found?
    public void search(String searchTarget, List<DataHolder> input) {
        log.info("Input: {}", input.toString());
        if (input.size() > 1) {
            SplitInputHolder splitInput = split(input);
            log.info("Input: {}", splitInput.toString());
            search(searchTarget, splitInput.getUpperHalf());
            search(searchTarget, splitInput.getLowerHalf());
        } else {
            if (input.get(0).getName().equalsIgnoreCase("testName")) {
//                TODO: get index in original input
                int index = 0;
                locationArray.add(index);
            }
        }
    }
}
