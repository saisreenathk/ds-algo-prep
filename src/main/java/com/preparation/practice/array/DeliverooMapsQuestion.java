package com.preparation.practice.array;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/discuss/interview-question/1981043/Deliveroo-India-or-SDE-2-or-OA-or-Karat
 */
public class DeliverooMapsQuestion {

    public static void main(String[] args) {
        String[][] logs1 = new String[][]{
                {"58523", "user_1", "resource_1"},
                {"62314", "user_2", "resource_2"},
                {"54001", "user_1", "resource_3"},
                {"200", "user_6", "resource_5"},
                {"215", "user_6", "resource_4"},
                {"54060", "user_2", "resource_3"},
                {"53760", "user_3", "resource_3"},
                {"58522", "user_22", "resource_1"},
                {"53651", "user_5", "resource_3"},
                {"2", "user_6", "resource_1"},
                {"100", "user_6", "resource_6"},
                {"400", "user_7", "resource_2"},
                {"100", "user_8", "resource_6"},
                {"54359", "user_1", "resource_3"},
        };

        String[][] logs2 = new String[][]{
                {"300", "user_1", "resource_3"},
                {"599", "user_1", "resource_3"},
                {"900", "user_1", "resource_3"},
                {"1199", "user_1", "resource_3"},
                {"1200", "user_1", "resource_3"},
                {"1201", "user_1", "resource_3"},
                {"1202", "user_1", "resource_3"}
        };

        String[][] logs3 = new String[][]{
                {"300", "user_10", "resource_5"}
        };
        findEachUserStartAndEndTime(logs1);
    }

    private static void findEachUserStartAndEndTime(String[][] logs1) {
        Map<String, Pair> userMap = new HashMap<>();

        for (String[] eachRow : logs1) {
            if (userMap.containsKey(eachRow[1])) {
                //check if eachRow[0] is smaller than smallest or larger than the current largest in the map
                Pair eachPair = userMap.get(eachRow[1]);
                if (Integer.valueOf(eachRow[0]) < eachPair.getStartTime()) {
                    //update smallest
                    eachPair.setStartTime(Integer.valueOf(eachRow[0]));
                }
                if (Integer.valueOf(eachRow[0]) > eachPair.getEndTime()) {
                    eachPair.setEndTime(Integer.valueOf(eachRow[0]));
                }
                userMap.put(eachRow[1], eachPair);
            } else {
                userMap.put(eachRow[1], new Pair(Integer.valueOf(eachRow[0]), Integer.valueOf(eachRow[0])));
            }
        }

        for (String eachUser : userMap.keySet()) {
            System.out.println(
                    eachUser + ": " + userMap.get(eachUser).getStartTime() + " to " + userMap.get(eachUser)
                            .getEndTime());
        }
    }
}


@Getter
@Setter
@AllArgsConstructor
class Pair {
    private int startTime;
    private int endTime;
}
