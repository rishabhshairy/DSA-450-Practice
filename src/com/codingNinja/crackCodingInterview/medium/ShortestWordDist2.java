package com.codingNinja.crackCodingInterview.medium;

public class ShortestWordDist2 {
    public static int minimumDistance(String[] arr, String book1, String book2) {
        // Write your code here
        int minDis = Integer.MAX_VALUE;
        int p1 = -1;
        int p2 = -1;
        for (int i = 0; i < arr.length; i++) {
            if (book1.equals(arr[i])) {
                p1 = i;
            }
            if (book2.equals(arr[i])) {
                p2 = i;
            }

            if (p1 != -1 && p2 != -1) {
                minDis = Math.min(minDis, Math.abs(p1 - p2));
            }
        }
        return minDis;
    }
}
