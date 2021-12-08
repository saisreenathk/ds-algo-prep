package com.preparation.practice.array;

public class LongestMoutain {

    public static void main(String[] args) {
        LongestMoutain l = new LongestMoutain();
        int a[] = {5, 6, 1, 2, 3, 4, 5, 4, 3, 2, 0, 1, 2, 3, -2, 4};
        System.out.println(l.longestMountainCalc(a));
    }

    public int longestMountainCalc(int[] a) {
        //identify the peaks and then calculate the length of the longest peak
        if (a.length < 3) {
            return 0;
        }
        int longestPeak = 0;
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i - 1] < a[i] && a[i] > a[i + 1]) {
                //peak found at i
                int currentPeakLen = 1;
                int start = i;
                inner1:
                while (start >= 1) {
                    if (a[start] > a[start - 1]) {
                        currentPeakLen++;
                        start--;
                    } else {
                        break inner1;
                    }
                }
                int end = i;
                inner2:
                while (end < a.length - 1) {
                    if (a[end] > a[end + 1]) {
                        currentPeakLen++;
                        end++;
                    } else {
                        break inner2;
                    }
                }
                if (currentPeakLen > longestPeak) {
                    longestPeak = currentPeakLen;
                }
            }
        }
        return longestPeak;
    }
}
