package com.dimSearch.nDimSearch.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Deque;

@Data
@AllArgsConstructor
public class OffsetData {
    private int upperSplitOffset;
    private int lowerSplitOffset;
    private Deque offsetDirections;
}
