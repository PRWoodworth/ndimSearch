package com.dimSearch.nDimSearch.data;

import lombok.*;

import java.util.List;

@Getter
@Setter
//@AllArgsConstructor
public class SplitInputHolder {
    private List<DataHolder> lowerHalf;
    private List<DataHolder> upperHalf;

    public SplitInputHolder(List<DataHolder> lowerHalf, List<DataHolder> upperHalf) {
        this.lowerHalf = lowerHalf;
        this.upperHalf = upperHalf;
    }
}


