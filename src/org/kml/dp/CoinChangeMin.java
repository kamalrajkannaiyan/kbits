package org.kml.dp;

import java.util.Arrays;

public class CoinChangeMin {
    public static void main(String[] args) {
        //int[] coins = {5,2,1};
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
    public static int coinChange(int[] coins, int amount) {
        int[][] cache = new int[amount + 1][coins.length];
        for(int[] row: cache)
        {
            Arrays.fill(row, -1);
        }
        int cnt = coinChange(coins, amount, 0, cache);
        return (cnt == Integer.MAX_VALUE)? -1:cnt;
    }
    public static int coinChange(int[] coins, int amount, int start, int[][] cache) {

        if(start == coins.length)
        {
            if(amount == 0)
                return 0;
            else
                return Integer.MAX_VALUE;
        }
        if(amount == 0) return 0;
        if(amount < 0) return Integer.MAX_VALUE;

        if(cache[amount][start] != -1) return cache[amount][start];
        int pick = coinChange(coins, amount - coins[start], start, cache);
        if (pick != Integer.MAX_VALUE)
            pick += 1;
        int noPick = coinChange(coins, amount, start + 1, cache);
        return cache[amount][start] = Math.min(pick, noPick);
    }
}
