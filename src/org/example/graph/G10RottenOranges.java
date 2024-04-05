package org.example.graph;

import java.util.LinkedList;
import java.util.Queue;

public class G10RottenOranges {
    public static void main(String[] args)
    {
        int[][] graph = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int duration = durationToRotten(graph);
        System.out.println("Duration " + duration);
    }

    private static int durationToRotten(int[][] grid)
    {
        if (grid == null || grid.length == 0) return -1;
        int duration = 0, totalOranges = 0, rottenOranges = 0;
        int ROWS = grid.length, COLS = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // find rotten oranges, totalOranges
        for(int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < COLS; col++)
            {
                if (grid[row][col] == 2)
                {
                    queue.offer(new int[]{row, col});
                    rottenOranges++;
                }
                if (grid[row][col] != 0)
                {
                    totalOranges++;
                }
            }
        }

        // process rotten oranges
        while (!queue.isEmpty())
        {
            int queueSize = queue.size();
            while (queueSize-- > 0)
            {
                int[] rottenOrange = queue.poll();
                for(int[] dir: dirs)
                {
                    int[] adj = new int[]{rottenOrange[0] + dir[0], rottenOrange[1] + dir[1]};
                    if (isWithInBounday(adj, ROWS, COLS) && grid[adj[0]][adj[1]] == 1)
                    {
                        queue.offer(adj);
                        grid[adj[0]][adj[1]] = 2;
                        rottenOranges++;
                    }
                }
            }

            System.out.println("Total Oranges = " + totalOranges + " ,rottenOranges = " + rottenOranges);
            if(!queue.isEmpty())
            {
                duration++;
            }
        }
        // return duration
        return (totalOranges == rottenOranges) ? duration : -1;
    }

    private static boolean isWithInBounday(int[] cell, int maxRow, int maxCol)
    {
        return cell[0] >= 0 && cell[0] < maxRow && cell[1] >= 0 && cell[1] < maxCol;
    }
}
