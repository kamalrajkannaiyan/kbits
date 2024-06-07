package org.kml.strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubstrings {
    public static void main(String[] args) {
        String s = "ABCD";
        List<String> substrings = generateAllSubstringsRec(s);
        int i = 1;
        for (String comn:substrings)
            System.out.println((i++)+"-->"+comn);
    }

    static List<String> generateAllSubstrings(String s)
    {
        List<String> ans1 = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                //System.out.println(i + "---" + j);
                ans1.add(s.substring(i, j));
            }
        }
        return ans1;
    }
    static void partitionHelper(int index, String s, List < String > path, List < List < String >> res) {
        if (index == s.length()) {
            res.add(new ArrayList < > (path));
            return;
        }
        for (int i = index; i < s.length(); ++i) {
            //if (isPalindrome(s, index, i))
            {
                path.add(s.substring(index, i + 1));
                partitionHelper(i + 1, s, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
    static List<String> generateAllSubstringsRec(String s)
    {
        return generateAllSubstringsRec(s, 0, "");
    }
    static List<String> generateAllSubstringsRec(String s, int start, String ans)
    {
        List<String> ans1 = new ArrayList<>();
        if (start == s.length())
        {
            ans1.add(ans);
            return ans1;
        }
        for (int i = start; i < s.length(); ++i)
        {
            generateAllSubstringsRec(s, i + 1, s.substring(start, i +1));
        }
        return ans1;
    }
}
