package com.preparation.ctci.Ch_01_Arrays_and_Strings.Q1_01_Is_Unique;

public class QuestionA {
	public static boolean isUniqueChars(String str) {
		if (str.length() > 128) {
			return false;
		}
		boolean[] char_set = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			System.out.println("str.chartAt("+i+")="+(int)str.charAt(i)+" or char value="+str.charAt(i));
			if (char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"abcde"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word));
		}
	}

}
