package com.dimSearch.nDimSearch.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
public class SplitInputHolder {
    private @NonNull Collection<?> upperHalf;
    private @NonNull Collection<?> lowerHalf;
}


