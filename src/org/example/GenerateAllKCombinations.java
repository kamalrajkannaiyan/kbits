package org.example;

import jdk.internal.org.objectweb.asm.tree.FrameNode;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllKCombinations
{
    public static void main(String[] args) {
        combine(4, 2);
    }

    public static void combine(int n, int k)
    {
        //backtrack(new ArrayList<>(),1, n, k);
        System.out.println();
        generateAllKCombinations(new ArrayList<>(), 1, n, k);
    }

    private static void generateAllKCombinations(List<Integer> comb, int start, int range, int combSize)
    {
        System.out.println("Combination --- "+comb + " --- start exploring from "+ start);
        if(comb.size() == combSize)
        {
            System.out.println(comb);
            return;
        }
        for (int child = start; child <= range; child++)
        {
            comb.add(child);
            generateAllKCombinations(comb, child + 1, range, combSize);
            comb.remove(comb.size() - 1);
        }
    }
    public static void backtrack(List<Integer> ans, int start, int n, int combSize)
    {
        if (ans.size() == combSize)
        {
            System.out.println(ans);
            return;
        }
        for (int i = start; i <= n; i++)
        {
            ans.add(i);
            backtrack(ans, i + 1, n, combSize);
            ans.remove(ans.size() - 1);
        }
    }
    public List<List<Integer>> combineOrig(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrackOrig(new ArrayList<>(), 1, ans, n, k);
        return ans;
    }

    public void backtrackOrig(List<Integer> curr, int i, List<List<Integer>> ans, int n, int k) {
        if (curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int num = i; num <= n; num++) {
            curr.add(num);
            backtrackOrig(curr, num + 1, ans, n, k);
            curr.remove(curr.size() - 1);
        }
    }
}