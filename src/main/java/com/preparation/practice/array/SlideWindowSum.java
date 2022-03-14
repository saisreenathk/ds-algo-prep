package com.preparation.practice.array;

import java.util.Arrays;

public class SlideWindowSum {

    public static double[] findAverages(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1];

        int sum = 0;
        int start = 0;
        int index = 0;
        for (int end = 0; end < arr.length; end++) {
            sum = sum + arr[end];

            if (end - start + 1 > k) {
                sum -= arr[start];
                start++;
            }

            //window met
            if (end - start + 1 == k) {
                result[index] = (double) sum / k;
                index++;
            }


        }
        return result;
    }

    public static void main(String[] args) {
        double[] result = SlideWindowSum.findAverages(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }
}
