package org.example.arrays;

public class MaxConsicutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1,1,0,0,1,1,1};
        System.out.println(maxConsecutiveOnes(arr));
    }
    private static int maxConsecutiveOnes(int[] arr)
    {
        int maxConsecutiveOnes = 0, consecutiveOnes=0;
        for (int num: arr)
        {
            if(num == 1)
            {
                consecutiveOnes++;
            }
            else
            {
               maxConsecutiveOnes = Math.max(maxConsecutiveOnes, consecutiveOnes);
               consecutiveOnes = 0;
            }
        }
        return Math.max(maxConsecutiveOnes, consecutiveOnes);
    }
}
