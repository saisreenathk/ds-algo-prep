package com.preparation.practice.slidingwindow;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 find the sub array sum that matches the given sum: k by 2 pointer and sliding window
 */
public class HousingArea {

    public static void main(String[] args) {

        int plots[] = {1, 3, 2, 1, 4, 1, 3, 2, 1, 1};
        int n = plots.length;
        int k = 8;

        housing(plots, n, k);
        //firstUniqChar("loveleetcode");//test commit

    }

    private static void housing(int[] plots, int n, int k) {
        int i = 0;
        int j = 0;
        int currSum = 0;

        while (j < plots.length) {
            currSum += plots[j];
            j++;

            while (currSum > k && i < j) {
                currSum -= plots[i];
                i++;
            }

            if (currSum == k) {
                System.out.println("area from: " + i + " - " + (j - 1));
            }
        }
    }

    private static char firstUniqChar(String s) {
        char[] sArr = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();

        for(Character c: sArr){
            map.computeIfPresent(c, (k,v)->v+1);
            map.putIfAbsent(c,1);
        }

        return map.entrySet().stream().filter(x-> x.getValue().equals(1))
                .map(Map.Entry::getKey).findFirst().get();
    }
}
