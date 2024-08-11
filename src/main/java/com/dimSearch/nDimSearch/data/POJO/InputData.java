package com.dimSearch.nDimSearch.data.POJO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
public class InputData {
    private String searchTarget;
    private ArrayList<ArrayList<?>> input;
}
