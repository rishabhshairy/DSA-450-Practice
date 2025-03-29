package com.leetCode.heaps.med;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class KPairsWithSmallestSum {

    static class SumIndex {
        int sum;
        int index;

        public SumIndex(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }

    /**
     * Optimal Solution --> O(k*log*K)
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<SumIndex> minHeap = new PriorityQueue<>((x, y) -> x.sum - y.sum);

        // first push all pair with num2[0]
        for (int x : nums1) {
            minHeap.offer(new SumIndex(x + nums2[0], 0));
        }

        // now poll and form pair with other nums of num2
        while (k > 0 & !minHeap.isEmpty()) {
            SumIndex curr = minHeap.poll();
            int sum = curr.sum;
            int index = curr.index;

            List<Integer> currPair = new ArrayList<>();
            currPair.add(sum - nums2[index]);
            currPair.add(nums2[index]);
            result.add(currPair);

            // for more elements push again
            if (index + 1 < nums2.length) {
                minHeap.offer(new SumIndex(sum - nums2[index] + nums2[index + 1], index + 1));
            }
            k--;
        }
        return result;
    }

    static class Pair {
        int a;
        int b;
        int sum;

        public Pair(int a, int b, int sum) {
            this.a = a;
            this.b = b;
            this.sum = sum;
        }
    }

    /**
     * This is brute force solution
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<List<Integer>> kSmallestPairsBruteForce(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((x, y) -> x.sum - y.sum);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                minHeap.add(new Pair(nums1[i], nums2[j], nums1[i] + nums2[j]));
            }
        }
        List<List<Integer>> result = new ArrayList<>();

        while (k > 0 && !minHeap.isEmpty()) {
            List<Integer> nums = new ArrayList<>();
            Pair curr = minHeap.poll();
            nums.add(curr.a);
            nums.add(curr.b);
            result.add(nums);
            k--;
        }
        return result;
    }
}
