package com.preparation.practice.array;

public class StringPalindrome {

    public static void main(String[] args) {
        StringPalindrome sp = new StringPalindrome();
        String s = "acbcwa";
        sp.checkPalindrome(s);
    }

    private void checkPalindrome(String s) {
        String r = reverseString(s);

        if (r.equals(s)) {
            System.out.println("palindrome");
        } else {
            System.out.println("not palindrome");
        }
    }

    private String reverseString(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        return s.charAt(s.length() - 1) + reverseString(s.substring(0, s.length() - 1));
    }
}
