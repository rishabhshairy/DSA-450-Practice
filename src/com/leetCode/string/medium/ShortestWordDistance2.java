package com.leetCode.string.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance2 {

    Map<String, List<Integer>> wordMap;

    public ShortestWordDistance2(String[] wordDict) {
        wordMap = new HashMap<>();
        for (int i = 0; i < wordDict.length; i++) {
            wordMap.computeIfAbsent(wordDict[i], k -> new ArrayList<>()).add(i);
        }
    }

    int shortest(String word1, String word2) {
        // find index list for word1 and word2
        List<Integer> indexList1 = wordMap.get(word1);
        List<Integer> indexList2 = wordMap.get(word2);
        int minDis = Integer.MAX_VALUE;
        int i = 0, j = 0;

        while (i < indexList1.size() && j < indexList2.size()) {
            minDis = Math.min(minDis, Math.abs(indexList1.get(i) - indexList2.get(j)));

            if (indexList1.get(i) < indexList2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return minDis;
    }
}
