package org.kml.permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {
    private static void permute(String s) {
        permute(s, 0, new HashSet<>(), new ArrayList<>());
    }

    private static void permute(String s, int idx, Set<Character> processed, List<Character> ans) {
        if (ans.size() == s.length()) {
            System.out.println(ans);
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            char c = s.charAt(i);
            //if (!processed.contains(c))
            {
                processed.add(c);
                ans.add(c);

                permute(s, i + 1, processed, ans);

                ans.remove(ans.size() - 1);
                processed.remove(c);
            }
        }
    }

    public static void main(String[] args) {
        String s = "ABC";
        permute(s);
    }
}
