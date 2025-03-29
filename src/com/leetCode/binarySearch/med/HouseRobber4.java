package com.leetCode.binarySearch.med;

import java.util.Arrays;

public class HouseRobber4 {
    public static void main(String[] args) {
        HouseRobber4 obj = new HouseRobber4();
        obj.minCapability(new int[]{2, 3, 5, 9}, 2);
    }

    public int minCapability(int[] nums, int k) {
        int low = Arrays.stream(nums).min().getAsInt();
        int high = Arrays.stream(nums).max().getAsInt();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (check(nums, mid) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low);
        return low;
    }

    private int check(int[] nums, int mid) {
        int take = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= mid) {
                take++;
                i++;
            }
        }
        return take;
    }
}
