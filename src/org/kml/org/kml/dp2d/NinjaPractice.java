package org.kml.org.kml.dp2d;

import java.util.Arrays;

public class NinjaPractice {
    public static void main(String[] args) {
        int[][] days = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };
        int[][] cache = new int[days.length][days[0].length + 1];
        for (int[] row:cache)
        {
            Arrays.fill(row, -1);
        }
        for (int[] row:days)
        {
            System.out.println(Arrays.toString(row));
        }
        int max = maxPoints(days, days.length - 1, days[0].length, cache);
        System.out.println("Max Points " + max);
        for (int[] row:cache)
        {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Tabulation ------------");
        for (int[] row:cache)
        {
            Arrays.fill(row, -1);
        }
        int max1 = maxPointsTabulation(days, cache);
        System.out.println("Max Points " + max1);
        for (int[] row:cache)
        {
            System.out.println(Arrays.toString(row));
        }
    }

    private static int maxPoints(int[][] days, int day, int last, int[][] cache)
    {
        if(day < 0) return 0;
        if (cache[day][last] != -1) return cache[day][last];
        int max = 0;
        for (int activity = 0; activity < days[0].length; activity++) {
            if(activity != last)
            {
              max = Math.max(max, days[day][activity] + maxPoints(days, day - 1, activity, cache));
            }
        }
        return cache[day][last] = max;
    }
    private static int maxPointsTabulation(int[][] points, int[][] cache)
    {
        for (int activity = 0; activity < points[0].length; activity++)
        {
            int max = 0;
            for (int i = 0; i < points[0].length; i++) {
                if(i != activity)
                {
                    max = Math.max(max, points[0][i]);
                }
            }
            cache[0][activity] = max;
        }
        for (int day = 1; day < points.length; day++) {
            System.out.println(Arrays.toString(points[day]));
            for (int activity = 0; activity < points[day].length; activity++) {
                cache[day][activity] = Math.max(cache[day][activity], points[day][activity] + cache[day - 1][activity]);
            }
        }
        return cache[points.length - 1][points[0].length - 1];
    }

}
