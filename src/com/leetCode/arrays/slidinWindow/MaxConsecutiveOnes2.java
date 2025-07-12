package com.leetCode.arrays.slidinWindow;

public class MaxConsecutiveOnes2 {
    public static void main(String[] args) {
        MaxConsecutiveOnes2 obj = new MaxConsecutiveOnes2();
        obj.findMaxConsecutiveOnes(new int[]{1,0,1,1,0});
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int l = 0, r = 0;
        int k = 1;
        while (r < nums.length) {
            if (nums[r++] == 0) {
                System.out.println(r);
                --k;
            }
            if (k < 0 && nums[l++] == 0) {
                ++k;
            }
        }
        return r - l;
    }
}
