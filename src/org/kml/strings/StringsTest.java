package org.kml.strings;

public class StringsTest {
    public static void main(String[] args) {
        String s = "ABCD";
        System.out.println(s.substring(0, 0)); //""
        System.out.println(s.substring(0, 1)); // "A"

        System.out.println(s.substring(s.length() - 1, s.length())); // D

    }
}
