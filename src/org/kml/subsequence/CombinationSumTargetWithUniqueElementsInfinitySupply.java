package org.kml.subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTargetWithUniqueElementsInfinitySupply {
    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        int target = 7;
        System.out.println("Input " + Arrays.toString(nums));
        List<List<Integer>> combos = findCombinations(nums, target);
        for (List<Integer> ans: combos)
        {
            System.out.println(ans);
        }
    }

    static List<List<Integer>> findCombinations(int[] nums, int target)
    {
        return findCombinations(nums, target, 0, new ArrayList<>());
    }
    static List<List<Integer>> findCombinations(int[] nums, int target, int start, List<Integer> subSeq)
    {
        List<List<Integer>> res = new ArrayList<>();
        if (target == 0)
        {
            res.add(new ArrayList<>(subSeq));
            return res;
        }
        if (start == nums.length) return res;
        res.addAll(findCombinations(nums, target, start + 1, subSeq));
        if(nums[start] <= target)
        {
            subSeq.add(nums[start]);
            res.addAll(findCombinations(nums, target - nums[start], start, subSeq));
            subSeq.remove(subSeq.size() - 1);
        }
        return res;
    }
}
