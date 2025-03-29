package com.leetCode.binarySearch.med;

public class MinTimeToRepairCars {
    public static void main(String[] args) {
        MinTimeToRepairCars obj = new MinTimeToRepairCars();
        obj.repairCars(new int[]{4, 2, 3, 1}, 10);
    }

    public long repairCars(int[] ranks, int cars) {
        long left = 1;
        long right = (long) 1e14;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (isTimeEnough(ranks, mid) >= cars) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
        return left;
    }

    private long isTimeEnough(int[] ranks, long time) {
        long totalCars = 0;
        for (int rank : ranks) {
            long cars = (long) Math.sqrt(time / rank);
            totalCars += cars;
        }
        return totalCars;
    }
}
