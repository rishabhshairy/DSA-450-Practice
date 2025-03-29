package com.company.linkedIn;

import java.util.ArrayList;
import java.util.List;

public class NestedListWeightSum {


    public int depthSum(List<NestedInteger> nestedList) {
        return computeDepthSum(nestedList, 1); // Starting with depth level 1
    }

    private int computeDepthSum(List<NestedInteger> nestedList, int depth) {
        int totalSum = 0;

        for (NestedInteger item : nestedList) {
            if (item.isInteger()) {
                totalSum += item.getInteger() * depth;
            } else {
                totalSum += computeDepthSum(item.getList(), depth + 1);
            }
        }
        return totalSum;
    }

    static class NestedInteger {

        Integer val;
        List<NestedInteger> list;

        // Constructor initializes an empty nested list.
        public NestedInteger() {
            list = new ArrayList<>();
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            this.val = value;
            list = null;
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return list == null;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return val;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            this.val = value;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            list.add(ni);
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return list;
        }
    }
}
