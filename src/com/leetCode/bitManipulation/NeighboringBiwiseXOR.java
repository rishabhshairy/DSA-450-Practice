package com.leetCode.bitManipulation;

public class NeighboringBiwiseXOR {
    public boolean doesValidArrayExist(int[] derived) {
        int xorSum = 0;
        for (int i = 0; i < derived.length; i++) {
            xorSum ^= derived[i];
        }
        return xorSum == 0;
    }
}
