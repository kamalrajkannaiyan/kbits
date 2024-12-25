package org.kml.dp.lcs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCSMatrix {
    public static void main(String[] args) {
        String str1 = "abaaa";
        String str2 = "baabaca";
        str1 = "KAMAL";
        str2 = "RAJ";
        int[][] mat = lcsMatrix(str1, str2);
        for (int[] row: mat)
        {
            System.out.println(Arrays.toString(row));
        }

        List<String> ansList = buildLCS(str1, str2, mat);
        for (String ans: ansList)
        {
            System.out.println(ans);
        }
    }

    static List<String> buildLCS(String str1, String str2, int[][] mat)
    {
        List<String> list = new ArrayList<>();
        list.add(constructLCS(str1, str2, mat));
        return list;
    }
    static String constructLCS(String str1, String str2, int[][] cache)
    {
        String ans = "";
        int s1 = cache.length - 1, s2 = cache[0].length - 1;
        while(s1 > 0 && s2 > 2) {
            System.out.println("s1 - " + s1 + " s2 - " + s2);
            if (str1.charAt(s1 - 1) == str2.charAt(s2 - 1)) {
                ans = str1.charAt(s1 - 1) + ans;
                s1--;
                s2--;
            } else {
                if (cache[s1][s2 - 1] > cache[s1 - 1][s2]) {
                    s2--;
                } else {
                    s1--;
                }
            }
        }
        return ans;
    }
    static int[][] lcsMatrix(String str1, String str2)
    {
        int str1Len = str1.length();
        int str2Len = str2.length();
        int[][] mat = new int[str1Len + 1][str2Len + 1];
        for(int s1 = 1; s1 <= str1Len; s1++)
        {
            for(int s2 = 1; s2 <= str2Len; s2++)
            {
                if(str1.charAt(s1 - 1) == str2.charAt(s2 - 1))
                {
                    mat[s1][s2] = 1 + mat[s1 - 1][s2 - 1];
                }
                else
                {
                    mat[s1][s2] = Math.max(mat[s1][s2 - 1], mat[s1 - 1][s2]);
                }
            }
        }
        return mat;
    }
}
