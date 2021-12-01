package com.preparation.tushar.string;

import java.util.*;

/**
 * https://leetcode.com/problems/anagrams/
 */
public class GroupAnagramsTogether {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<List<String>>();
        
        int listIndex = 0;
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> anagramGroup = new HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (anagramGroup.containsKey(sorted)) {
                int index = anagramGroup.get(sorted);
                List<String> listResult = result.get(index);    
                listResult.add(str);
            } else {
                List<String> resultList = new ArrayList<>();
                resultList.add(str);
                result.add(listIndex, resultList);
                anagramGroup.put(sorted, listIndex);
                listIndex++;
            }
        }
        return result;
    }
    
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<List<String>>();
        
        List<List<String>>  result= new ArrayList<>();
        Map<String,List<String>> resultMap = new HashMap<>();
        for(String eachString: strs){
            char[] eachCharArray = eachString.toCharArray();
            Arrays.sort(eachCharArray);
            
            if(resultMap.containsKey(new String(eachCharArray))){
                List<String> eachGroup = resultMap.get(new String(eachCharArray));
                eachGroup.add(eachString);
            }else{
                List<String> eachGroup = new ArrayList<>();
                eachGroup.add(eachString);
                resultMap.put(new String(eachCharArray),eachGroup );
            }
            
        }
        
        for(String eachKey:resultMap.keySet()){
        	result.add(resultMap.get(eachKey));
        }
        return result;
    }
               
    
}
