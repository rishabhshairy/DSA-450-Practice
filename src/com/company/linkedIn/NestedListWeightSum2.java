package com.company.linkedIn;

import java.util.List;

public class NestedListWeightSum2 {
    // Calculate the inverse depth sum of the given nest integer list.

    public int depthSumInverse(List<NestedListWeightSum.NestedInteger> nestedList) {
        // First, find the maximum depth of the nested list.
        int maxDepth = findMaxDepth(nestedList);
        // Then, calculate the depth sum with depth weights in inverse order.
        return calculateDepthSumInverse(nestedList, maxDepth);
    }

    private int calculateDepthSumInverse(List<NestedListWeightSum.NestedInteger> nestedList, int weight) {
        int totalSum = 0;
        for (NestedListWeightSum.NestedInteger item
                : nestedList) {
            if (item.isInteger()) {
                totalSum += item.getInteger() * weight;
            } else {
                totalSum += calculateDepthSumInverse(item.getList(), weight - 1);
            }
        }
        return totalSum;
    }

    private int findMaxDepth(List<NestedListWeightSum.NestedInteger> nestedList) {
        int maxDepth = 1;
        for (NestedListWeightSum.NestedInteger item : nestedList) {
            if (!item.isInteger()) {
                maxDepth = Math.max(maxDepth, 1 + findMaxDepth(item.getList()));
            }
        }
        return maxDepth;
    }
}
