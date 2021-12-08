package com.preparation.practice.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoAndThreeSum {

    public static void main(String[] args) {
        TwoAndThreeSum t = new TwoAndThreeSum();
        int[] arr = {10, 5, 2, 3, -6, 9, 11};
        //t.twoSum(arr, 4);

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 15};
        t.threeSum(arr2, 18);
    }

    public void twoSum(int[] arr, int n) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(n - i)) {
                System.out.println(i + " and " + (n - i));
            } else {
                set.add(i);
            }
        }
    }

    public void threeSum(int[] arr, int sum) {
        if (arr == null || arr.length < 3) {
            return;
        }
        Arrays.sort(arr);
        int j = 1;
        int k = arr.length - 1;
        int tempSum;
        for (int i = 0; i < arr.length - 2; i++) {
            while (j < k) {
                tempSum = arr[i] + arr[j] + arr[k];
                if (tempSum == sum) {
                    System.out.println(arr[i] + "," + arr[j] + "," + arr[k]);
                    j++;
                    k--;
                } else if (tempSum < sum) {
                    j++;
                } else {
                    k--;
                }
            }
            j = i + 1;
            k = arr.length - 1;
        }
    }
}
