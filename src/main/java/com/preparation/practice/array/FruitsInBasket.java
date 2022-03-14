package com.preparation.practice.array;

import java.lang.reflect.Array;
import java.util.LinkedHashMap;
import java.util.Map;

//https://www.educative.io/courses/grokking-the-coding-interview/Bn2KLlOR0lQ
public class FruitsInBasket {
    public static int findLength(char[] arr) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        int result = Integer.MIN_VALUE;

        for (int end = 0; end < arr.length; end++) {
            Integer currCount = (map.get(arr[end]) != null ? map.get(arr[end]) : 0);
            map.put(arr[end], currCount + 1);

            while (map.size() > 2) {
                for (Character c : map.keySet()) {
                    map.remove(c);
                    break;
                }
            }
            result = Math.max(result, map.values().stream().mapToInt(Integer::intValue).sum());
        }
        return result;
    }

    public static void main(String[] args) {
        char[] arr = {'A', 'D', 'D', 'D', 'D','D','B'};
        System.out.println(findLength(arr));
    }
}
