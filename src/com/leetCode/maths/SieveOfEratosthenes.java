package com.leetCode.maths;

import java.util.ArrayList;
import java.util.List;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 32;
        List<Integer> primes = findAllPrimes(n);
        System.out.println(primes);
    }

    private static List<Integer> findAllPrimes(int n) {
        List<Integer> primes = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            primes.add(1); // assuming each number is prime
        }

        primes.set(0, 0);
        primes.set(1, 0);

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primes.get(i) == 1) {
                // mark multiples of prime number as not prime
                for (int j = i * i; j <= n; j += i) {
                    primes.set(j, 0);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (primes.get(i) == 1) {
                result.add(i);
            }
        }
        return result;
    }

}
