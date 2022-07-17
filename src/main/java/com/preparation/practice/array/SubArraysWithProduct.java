package com.preparation.practice.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubArraysWithProduct {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        Set<List<Integer>> subarrays = new HashSet<>();

        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            if (arr[end] < target) {
                subarrays.add(List.of(arr[end]));
            }
            int productOfSubArr = 1;
            List<Integer> tempList = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                tempList.add(arr[i]);
                productOfSubArr *= arr[i];
            }
            if (productOfSubArr < target) {
                subarrays.add(new ArrayList<>(tempList));
            }
            tempList.clear();

            //time to shrink from the beginning
            while (productOfSubArr >= target) {
                productOfSubArr /= arr[start];
                start++;
                end = start;
                if (productOfSubArr < target) {
                    //add this start, end to subarrays
                    List<Integer> subList = new ArrayList<>();
                    for (int i = start; i <= end; i++) {
                        subList.add(arr[i]);
                    }
                    subarrays.add(subList);
                }
            }
        }
        return new ArrayList<>(subarrays);
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 10};
        List<List<Integer>> result = findSubarrays(arr, 30);
        for (List<Integer> eachList : result) {
            System.out.println(eachList.toString());
        }
    }
}
