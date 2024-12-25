package org.kml.greedy;

import java.util.ArrayList;
import java.util.List;

public class MinCoinChangeReq {
    private static List<Integer> minCoinChangeReq(int amount, int coins[])
    {
        List<Integer> change = new ArrayList<>();
        for(int coin: coins)
        {
            while (coin <= amount)
            {
                change.add(coin);
                amount -= coin;
            }
        }
        return change;
    }
    public static void main(String[] args) {
        int coins[] = {1000, 500, 100, 50, 20, 10, 5, 2, 1};
        int amount = 99;
        List<Integer> change = minCoinChangeReq(amount, coins);
        System.out.println("Min coins req to change " + amount + " is " + change);
    }
}
