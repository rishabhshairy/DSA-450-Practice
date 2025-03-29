package com.leetCode.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class ZeroArrayTransformation1 {

    /**
     * Difference Array Concept
     *
     * @param nums
     * @param queries
     * @return
     */
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n];
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            diff[l]--;
            diff[r + 1]++;
        }
        int currDiff = 0;
        for (int i = 0; i < n; i++) {
            currDiff += diff[i];
            if (currDiff + nums[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isZeroArrayBruteForce(int[] nums, int[][] queries) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] q : queries) {
            for (int i = q[0]; i <= q[1]; i++) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(i)) {
                if (nums[i] > 0) {
                    return false;
                }
            } else if (map.get(i) < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
