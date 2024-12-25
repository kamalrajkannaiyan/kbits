package org.kml.subsequence;

import java.util.*;

public class CombinationSum2 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target, List<Integer> processed, int idx) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length == idx)
        {
            if(target == 0)
            {
                List<Integer> comb = new ArrayList<>(processed);
                res.add(comb);
            }
            return res;
        }

        List<List<Integer>> leftComb = new ArrayList<>();
        List<List<Integer>> rightComb = new ArrayList<>();
        // pick
        if(candidates[idx] <= target)
        {
            processed.add(candidates[idx]);
            leftComb = combinationSum(candidates, target - candidates[idx], processed, idx + 1);
            processed.remove(processed.size() - 1);
        }
        // skip
        // skip duplicates also
        while(idx + 1 < candidates.length && candidates[idx] == candidates[idx + 1]) idx++;
        rightComb = combinationSum(candidates, target, processed, idx + 1);

        res.addAll(leftComb);
        res.addAll(rightComb);
        return res;
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        Arrays.sort(candidates);
        return combinationSum(candidates, target, new ArrayList<>(), 0);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> ans = combinationSum2(nums, 3);
        System.out.println(ans.size());
        for (List<Integer> comb: ans)
        {
            System.out.println(comb);
        }
    }
}
class Solution {
    Map<Character, char[]> digitToCharsMap = new HashMap<>();

    private void init()
    {
        digitToCharsMap.put('2', new char[]{'a', 'b','c'});
        digitToCharsMap.put('3', new char[]{'d', 'e','f'});
        digitToCharsMap.put('4', new char[]{'g', 'h','i'});
        digitToCharsMap.put('5', new char[]{'j', 'k','l'});
        digitToCharsMap.put('6', new char[]{'m', 'n','o'});
        digitToCharsMap.put('7', new char[]{'p', 'q','r','s'});
        digitToCharsMap.put('8', new char[]{'t', 'u', 'v'});
        digitToCharsMap.put('9', new char[]{'w', 'x','y', 'z'});
    }

    public List<String> letterCombinations(String digits, String currComb, int idx) {
        List<String> res = new ArrayList<>();
        if(digits.length() == idx)
        {
            res.add(currComb);
            return res;
        }

        char[] chars = digitToCharsMap.get(digits.charAt(idx));
        for(char c: chars)
        {
            res.addAll(letterCombinations(digits, currComb + c, idx + 1));
        }
        return res;
    }
    public List<String> letterCombinations(String digits) {
        init();
        return letterCombinations(digits, "", 0);
    }
}