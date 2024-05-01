package org.kml;

public class GenerateAllCombinations
{
    public static void main(String[] args) {
        //List<Integer> input = new ArrayList<>();
        int[] input = new int[]{1,2};
        generateAllCombinations("",0, input);
    }

    public static void generateAllCombinations(String p, int currPos, int[] input)
    {
        if (p.length() == input.length)
        {
            System.out.println(p);
            return;
        }
        for (int i = 0; i < input.length; i++)
        {
            generateAllCombinations(p + input[i] , i + 1, input);
        }
    }
}
