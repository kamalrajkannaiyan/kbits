package org.kml.dp;

import java.util.ArrayList;
import java.util.List;

public class GenerateCharsBasedOnNums {

    public static void main(String[] args) {
        String num = "226";
        List<String> result =  generateChars(num, 0, new ArrayList<>());
        for (String s: result){
            System.out.println(s);
        }
    }

    public static List<String> generateChars(String s, int start, List<String> values) {
        List<String> result = new ArrayList<>();
        if (s.length() == start) {
            //System.out.println(values);
            result.add(convert(values));
            return result;
        }

        for (int idx = start; idx < s.length(); idx++) {
            String ss = s.substring(start, idx + 1);
            if (Integer.parseInt(ss) > 26) break;
            values.add(ss);
            result.addAll(generateChars(s, idx + 1, values));
            values.remove(values.size() - 1);
        }
        return result;
    }

    public static String convert(List<String> values){
        StringBuilder sb = new StringBuilder();
        for (String s: values){
            sb.append( (char)(Integer.parseInt(s) + 'A' - 1));
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
