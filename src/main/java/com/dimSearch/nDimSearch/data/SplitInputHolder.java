package com.dimSearch.nDimSearch.data;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
public class SplitInputHolder {
    private List<DataHolder> lowerHalf;
    private List<DataHolder> upperHalf;
}


