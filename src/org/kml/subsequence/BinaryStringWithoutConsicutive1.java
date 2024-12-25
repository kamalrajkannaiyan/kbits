package org.kml.subsequence;

import java.util.ArrayList;
import java.util.List;

public class BinaryStringWithoutConsicutive1 {

    private static void generate(int cnt, List<Integer> path)
    {
        if(cnt == 0)
        {
            System.out.println(path);
            return;
        }

        path.add(0);
        generate(cnt - 1, path);
        path.remove(path.size() - 1);

        if(path.isEmpty() || (!path.isEmpty() && path.get(path.size() - 1) != 1))
        {
            path.add(1);
            generate(cnt - 1, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        generate(4, new ArrayList<>());
    }
}
