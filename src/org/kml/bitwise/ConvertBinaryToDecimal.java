package org.kml.bitwise;

public class ConvertBinaryToDecimal
{
    static int convertBinaryToDecimal(String num)
    {
        int decimal = 0;
        int len = num.length();
        for(int place = 0; place < len; place++)
        {
            decimal += (num.charAt(len - place - 1) - '0') * (1 << place);
        }
        System.out.println(num +" --> "+ decimal);
        return decimal;
    }

    public static void main(String[] args) {
        convertBinaryToDecimal("0");
        convertBinaryToDecimal("10");
        convertBinaryToDecimal("11");
        convertBinaryToDecimal("110");
        convertBinaryToDecimal("1010");
        convertBinaryToDecimal("1111");
    }
}
