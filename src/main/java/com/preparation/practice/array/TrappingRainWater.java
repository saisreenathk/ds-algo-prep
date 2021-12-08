package com.preparation.practice.array;

public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        int a[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(t.findMaxWaterTrapped(a));
    }

    private int findMaxWaterTrapped(int[] a) {
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;

        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            if (a[i] <= a[j]) {
                if (a[i] > leftMax) {
                    leftMax = a[i];
                } else {
                    res += leftMax - a[i];
                }
                i++;
            } else if (a[j] < a[i]) {
                if (a[j] > rightMax) {
                    rightMax = a[j];
                } else {
                    res += rightMax - a[j];
                }
                j--;
            }
        }
        return res;
    }
}
