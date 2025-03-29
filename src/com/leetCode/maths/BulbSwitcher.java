package com.leetCode.maths;

import java.util.Arrays;

public class BulbSwitcher {

    public static void main(String[] args) {
        BulbSwitcher obj = new BulbSwitcher();
        obj.bulbSwitch(99999);
    }

    public int bulbSwitch(int n) {
        int[] bulb = new int[n + 1];
        Arrays.fill(bulb, 1);

        // 2nd round
        for (int j = 1; j <= n; j++) {
            if (j % 2 == 0) {
                bulb[j] = 0;
            }
        }
        int round = 3;
        for (int i = 1; i <= n; i++) {
            if (i % round == 0) {
//                Arrays.fi
            }
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (bulb[i] == 1) {
                cnt++;
            }
        }
        System.out.println(cnt);
        return cnt;
    }
}
