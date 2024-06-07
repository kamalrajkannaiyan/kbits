package org.kml.math;

public class Modulo {
    public static void main(String[] args) {
        int x = 8, mod = 5;
        System.out.println(x + " mod " + mod + " = " + x % mod);
        x = -8;
        mod = 5;
        System.out.println(x + " mod " + mod + "; Mode = " + mod(x, mod) + ", PositiveMode " + positiveMod(x, mod));
        x = -1;
        mod = 1;
        System.out.println(x + " mod " + mod + "; Mode = " + mod(x, mod) + ", PositiveMode " + positiveMod(x, mod));
    }

    private static int mod(int x, int mod) {
        return (x % mod);
    }

    private static int positiveMod(int x, int mod) {
        return (x % mod + mod) % mod;
    }
}
