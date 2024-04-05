package org.example.rec;

public class PrintNameNTimes {
    public static void main(String[] args) {
        print("Kamal", 5);
    }
    private static void print(String name, int count)
    {
        if(count<1) return;
        print(name, count - 1);
        System.out.println(count + " " + name);
    }
}
