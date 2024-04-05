package org.example.rec;

public class PrintNameXtoYTimes {
    public static void main(String[] args) {
        print("Kamal", 6,10);
    }
    private static void print(String name, int from, int to)
    {
        if(from>to) return;
        System.out.println(from + " " + name);
        print(name, from + 1, to);
    }}
