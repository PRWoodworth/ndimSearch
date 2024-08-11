package com.dimSearch.nDimSearch.service;

import com.dimSearch.nDimSearch.data.SplitInputHolder;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

@Service
public class NDimSearchService {
    private static final Logger log = LogManager.getLogger(NDimSearchService.class.getName());

    public SplitInputHolder splitInput(ArrayList<ArrayList<?>> input){
        ArrayList<ArrayList<?>> lowerHalf = (ArrayList<ArrayList<?>>) input.subList(0, input.size()/2);
        ArrayList<ArrayList<?>> upperHalf = (ArrayList<ArrayList<?>>) input.subList((input.size()/2), input.size());
        return new SplitInputHolder(upperHalf, lowerHalf);
    }

    public boolean checkInput(ArrayList<ArrayList<?>> input){
        //TODO: ensure this checks if the first element of the collection is a collection
        return input.getFirst() instanceof ArrayList;
    }

    public void search(String searchTarget, ArrayList<ArrayList<?>> input){
        if(checkInput(input)) {
            SplitInputHolder splitHolder = splitInput(input);
            //TODO: datatype errors on below 2 lines. >:(
//            search(searchTarget, splitHolder.getLowerHalf());
//            search(searchTarget, splitHolder.getUpperHalf());
        } else {
            //TODO: recursive until atomic element found
        }

    }
      
}
