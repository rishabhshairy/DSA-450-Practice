package com.leetCode.string.medium;

import java.util.Map;

public class ShortestWordDistance {
    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "makes";
        ShortestWordDistance obj = new ShortestWordDistance();
        obj.shortestDistance(words, word1, word2);
    }

    public int shortestDistance(String[] words, String word1, String word2) {
        int minDis = Integer.MAX_VALUE;
        int p1 = -1;
        int p2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                p1 = i;
            }
            if (word2.equals(words[i])) {
                p2 = i;
            }

            if (p1 != -1 && p2 != -1) {
                minDis = Math.min(minDis, Math.abs(p1 - p2));
            }
        }
        return minDis;
    }
}
