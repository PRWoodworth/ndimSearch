package com.dimSearch.nDimSearch.data.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DataGenInput {
    private int length;
    private int upperBound;
    private int lowerBound;
}
