package org.example.rec;

public class Palindrome {
    public static void main(String[] args) {
        String str = "LIRRIL";
        System.out.println(isPalindrome(str, 0, str.length() - 1));
    }
    private static boolean isPalindrome(String str, int start, int end)
    {
        if(start < end)
        {
            if(str.charAt(start) != str.charAt(end)) return false;
            return isPalindrome(str, start + 1, end - 1);
        }
        return true;
    }
}
