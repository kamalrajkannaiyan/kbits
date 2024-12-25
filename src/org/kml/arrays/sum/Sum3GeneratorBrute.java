package org.kml.arrays.sum;

import java.util.*;

public class Sum3GeneratorBrute {
    private static List<List<Integer>> findAllUniqueTriplets(int[] nums)
    {
        Set<List<Integer>> tripletSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0)
                    {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet);
                        tripletSet.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(tripletSet);
    }

    static int sum(List<Integer> list)
    {
        int sum = 0;
        for (int num: list)
        {
            sum += num;
        }
        return sum;
    }
    private static List<List<Integer>> findAllUniqueTriplets(int[] nums, int reqElements, int start, List<Integer> currElements)
    {
        List<List<Integer>> ans = new ArrayList<>();
        if (reqElements == 0)
        {
            if(sum(currElements) == 0)
            {
                if(sum(currElements) == 0)
                {
                    ans.add(new ArrayList<>(currElements));
                }
            }
            return ans;
        }

        for (int idx = start; idx < nums.length; idx++)
        {
            currElements.add(nums[idx]);
            List<List<Integer>> subAns = findAllUniqueTriplets(nums, reqElements - 1, idx + 1, currElements);
            currElements.remove(currElements.size() - 1);
            ans.addAll(subAns);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        //List<List<Integer>> triplets = findAllUniqueTriplets(nums);
        List<List<Integer>> triplets = findAllUniqueTriplets(nums, 3, 0, new ArrayList<>());
        for (List<Integer> triplet: triplets)
        {
            System.out.println(triplet);
        }
    }
}
