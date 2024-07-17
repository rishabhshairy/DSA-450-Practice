package com.leetCode.binarySearch;

/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
 */
public class CapacityToShipPackageInDays {
    public static void main(String[] args) {

    }

    /**
     * This is binary search approach
     * @param weights
     * @param days
     * @return
     */
    public int shipWithinDays(int[] weights, int days) {

    }
    /**
     * We Can ship load between maxWeight and sum of all weights
     *
     * @param weights
     * @param days
     * @return
     */
    public static int shipWithinDaysBruteForce(int[] weights, int days) {
        int maxWeight = Integer.MIN_VALUE;
        int sumOfWeights = 0;

        for (int i = 0; i < weights.length; i++) {
            maxWeight = Math.max(maxWeight, weights[i]);
            sumOfWeights += weights[i];
        }

        // Now find least between maxWeight and totalWeight of load
        for (int i = maxWeight; i <= sumOfWeights; i++) {
            if (findDays(weights, i) <= days) {
                return i;
            }
        }
        return -1;
    }

    private static int findDays(int[] weights, int currentWeightCapacity) {
        int days = 1; // first day
        int load = 0;

        for (int i = 0; i < weights.length; i++) {
            if (load + weights[i] > currentWeightCapacity) {
                load = weights[i];
                days++;
            } else {
                load += weights[i];
            }
        }
        return days;
    }
}
