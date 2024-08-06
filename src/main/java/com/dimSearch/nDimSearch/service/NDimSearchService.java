package com.dimSearch.nDimSearch.service;

import com.dimSearch.nDimSearch.data.SplitInputHolder;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class NDimSearchService {
    private static final Logger log = LogManager.getLogger(NDimSearchService.class.getName());

    //TODO: ArrayList<Collection> instead of ArrayList<Object> ?

    public SplitInputHolder splitInput(ArrayList<Collection<?>> input){
        ArrayList<Collection<?>> lowerHalf = (ArrayList<Collection<?>>) input.subList(0, input.size()/2);
        ArrayList<Collection<?>> upperHalf = (ArrayList<Collection<?>>) input.subList((input.size()/2), input.size());
        return new SplitInputHolder(upperHalf, lowerHalf);
    }

    public boolean checkInput(ArrayList<Collection<?>> input){
        //TODO: ensure this checks if the first element of the collection is a collection
        return input.getFirst() instanceof Collection<?>;
    }

    public void search(String searchTarget, ArrayList<Collection<?>> input){
        //TODO: if input is list/array/etc., split
        if(checkInput(input)) {
            SplitInputHolder splitHolder = splitInput(input);
        }
        //TODO: recursive until atomic element found
    }
      
}
