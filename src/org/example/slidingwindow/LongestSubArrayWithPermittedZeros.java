package org.example.slidingwindow;

public class LongestSubArrayWithPermittedZeros
{
    public static void main(String[] args) {
        String str = "1101100111";
        char acceptableChar = '0';
        System.out.println(findLongestSubstringLength(str, acceptableChar, 2));
    }
    private static int findLongestSubstringLength(String str, char acceptableChar, int maxCount)
    {
        int maxLen = 0;
        int left = 0, acceptableCharCurrCount = 0;
        for (int right = 0; right < str.length(); right++)
        {
            // process the window
            char charToCheck = str.charAt(right);
            if (charToCheck == acceptableChar)
            {
                acceptableCharCurrCount++;
            }

            // validate the window constraint
            while (acceptableCharCurrCount > maxCount)
            {
                char charToRemove = str.charAt(left++);
                if(charToRemove == acceptableChar)
                {
                    acceptableCharCurrCount--;
                }
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
