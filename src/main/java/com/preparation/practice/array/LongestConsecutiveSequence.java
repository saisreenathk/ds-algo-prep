package com.preparation.practice.array;

import java.util.HashSet;
import java.util.Set;

/*
  identify the length of the sub sequence (absolute difference of 1) in the array which is longest
  easier sol is to sort and check for a band which is has a difference of 1 and create a new band if the
  difference is more.

  other solution is to check if an element can be starting point of a band, meaning no other numbers less than it
  whose difference is 1, then count for sub sequence that is increasing by difference of 1
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        int[] a = {1, 9, 3, 0, 18, 5, 2, 4, 10, 7, 12, 6};
        System.out.println(l.longestConsSequence(a));
    }

    private int longestConsSequence(int[] a) {
        //push elements to hash set
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }

        int result = 0;
        for (int i = 0; i < a.length; i++) {
            // identify band starting point
            int localLargest = 0;
            if (!set.contains(a[i] - 1)) {
                //possibly a[i] is starting point of a band
                localLargest = 1;
                int currNum = a[i];
                while (set.contains(currNum + 1)) {
                    //System.out.print(", "+currNum);
                    currNum = currNum + 1;
                    localLargest++;
                }
            }
            if (localLargest > result) {
                result = localLargest;
            }
        }
        return result;
    }
}
