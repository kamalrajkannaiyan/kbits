package org.kml.strings;

public class LargeOddNumber {
    public static String largeOddNum(String s) {
        String ans = "";
        int trailing = s.length() - 1;
        while(trailing>=0)
        {
            int d = s.charAt(trailing) - '0';
            if(d%2 == 1)
            {
                break;
            }
            trailing--;
        }
        int leading = 0;
        while(leading < trailing)
        {
            int d = s.charAt(leading) - '0';
            if( d != 0)
            {
                break;
            }
            leading++;
        }
        return s.substring(leading, trailing + 1);
    }

    public static void main(String[] args) {
        String s = "0214638";
        System.out.println(largeOddNum(s));
    }
}
