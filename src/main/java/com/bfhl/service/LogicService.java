package com.bfhl.service;

import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class LogicService {

    public List<Integer> fibonacci(int n) {
        List<Integer> res = new ArrayList<>();
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            res.add(a);
            int c = a + b;
            a = b;
            b = c;
        }
        return res;
    }

    public List<Integer> prime(List<Integer> arr) {
        List<Integer> res = new ArrayList<>();
        for (int x : arr) {
            if (isPrime(x)) res.add(x);
        }
        return res;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public int hcf(List<Integer> arr) {
        int res = arr.get(0);
        for (int x : arr) {
            res = gcd(res, x);
        }
        return res;
    }

    public int lcm(List<Integer> arr) {
        int res = arr.get(0);
        for (int x : arr) {
            res = res * x / gcd(res, x);
        }
        return res;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
