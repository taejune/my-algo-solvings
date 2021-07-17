package com.taejune.algorithm.basic;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    private static void reculsion(List<String> arr, List<String> result, int index, int n, int r) {
        if (r == 0) {
            System.out.println(result.toString());
            return;
        }

        for (int i = index; i < n; i++) {
            result.add(arr.get(i));
            reculsion(arr, result, i + 1, n, r - 1);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");
        arr.add("5");

        List<String> result = new ArrayList<>();
        reculsion(arr, result, 0, arr.size(), 3);
    }
}
