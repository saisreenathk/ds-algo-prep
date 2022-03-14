package com.preparation.practice.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindPermutation {

    public static boolean findPermutation(String str, String pattern) {
        int start = 0;
        List<Character> patternMap = pattern.chars().mapToObj(e->(char)e).collect(Collectors.toList());
        boolean result = false;
        char[] strArr = str.toCharArray();

        List<Character> currList = new ArrayList<>();
        for(int end = 0;end<strArr.length;end++){
            currList.add(strArr[end]);

            //check if the pattern is present so far, otherwise keep trimming
            while(currList.size()>0 && !patternMap.containsAll(currList)){
                //bad character, remove it from beginning
                currList.remove(Character.valueOf(strArr[start]));
                start++;
            }

            if(patternMap.containsAll(currList) && patternMap.size()==currList.size()){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findPermutation("odicf","dc"));
    }
}
