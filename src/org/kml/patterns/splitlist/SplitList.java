package org.kml.patterns.splitlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitList {
    static void splitList(List<Integer> list, int splitsCnt, int idx, List<Integer> path, List<List<Integer>> ans)
    {
        if(splitsCnt == 1)
        {
            List lastList = new ArrayList();
            for(int i = 0; i <= idx; i++)
            {
                lastList.add(list.get(i));
            }
            //System.out.println(path);
            ans.add(new ArrayList<>(path));
            ans.add(lastList);
            for (List<Integer> l: ans)
                System.out.print(l);
            System.out.println();
            return;
        }
        for (int start = idx; start >= 0; start--)
        {
            ans.add(new ArrayList<>(path));
            path.add(list.get(start));
            splitList(list, splitsCnt - 1, start - 1, path, ans);
            //path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        splitList(list, 2, list.size() - 1, new ArrayList<>(), new ArrayList<>());
    }
}
