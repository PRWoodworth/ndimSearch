package com.dimSearch.nDimSearch.data;

import java.util.ArrayList;
import java.util.Collection;

public class SplitInputHolder {
    private Collection<?> upperHalf;
    private Collection<?> lowerHalf;

    public SplitInputHolder(Collection<?> upperHalf, Collection<?> lowerHalf) {
        this.upperHalf = upperHalf;
        this.lowerHalf = lowerHalf;
    }

    public Collection<?> getUpperHalf() {
        return upperHalf;
    }

    public void setUpperHalf(Collection<?> upperHalf) {
        this.upperHalf = upperHalf;
    }

    public Collection<?> getLowerHalf() {
        return lowerHalf;
    }

    public void setLowerHalf(Collection<?> lowerHalf) {
        this.lowerHalf = lowerHalf;
    }
}
