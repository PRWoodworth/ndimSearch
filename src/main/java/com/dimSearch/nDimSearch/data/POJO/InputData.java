package com.dimSearch.nDimSearch.data.POJO;

import com.dimSearch.nDimSearch.data.DataHolder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class InputData {
    private String searchTarget;
    private List<DataHolder> input;

    public List<DataHolder> getInput() {
        return input;
    }

    public String getSearchTarget() {
        return searchTarget;
    }
}
