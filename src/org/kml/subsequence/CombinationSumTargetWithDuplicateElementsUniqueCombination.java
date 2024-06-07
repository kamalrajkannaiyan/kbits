package org.kml.subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTargetWithDuplicateElementsUniqueCombination {
    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        System.out.println(Arrays.toString(nums));
        int target = 8;
        List<List<Integer>> res = findUniqueCombination(nums, target);
        for (List comb: res)
        {
            System.out.println(comb);
        }
    }

    static List<List<Integer>> findUniqueCombination(int[] nums, int target)
    {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return findUniqueCombination(nums, target, 0, new ArrayList<>());
    }
    static List<List<Integer>> findUniqueCombination(int[] nums, int target, int start, List<Integer> comb)
    {
        List<List<Integer>> res = new ArrayList<>();
        if (target == 0)
        {
            List<Integer> ans = new ArrayList<>(comb);
            res.add(ans);
            return res;
        }
        for (int ind = start; ind < nums.length; ind++)
        {
            if (ind > start && nums[ind] == nums[ind - 1]) continue;
            if (nums[ind] > target) break;

            comb.add(nums[ind]);
            res.addAll(findUniqueCombination(nums, target - nums[ind], ind + 1, comb));
            comb.remove(comb.size() - 1);
        }
        return res;
    }
}
