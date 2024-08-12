package com.dimSearch.nDimSearch.service;

import com.dimSearch.nDimSearch.data.DataHolder;
import com.dimSearch.nDimSearch.data.SplitInputHolder;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


@Service
public class NDimSearchService {
    private static final Logger log = LogManager.getLogger(NDimSearchService.class.getName());

    public SplitInputHolder split(List<DataHolder> input){
        SplitInputHolder splitHolder = new SplitInputHolder(input.subList(0, input.size()/2), input.subList((input.size()/2), input.size()));
        return splitHolder;
    }

    public void search(String searchTarget, List<DataHolder> input){
        log.info("Input: {}", input);

//        TODO: implement basic half/half search first on unsorted 1d array
//        TODO: expand to 2d search
//        TODO: generalize to n-d

    }
      
}
