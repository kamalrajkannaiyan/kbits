package numbers.extra;

public class OddRepeatedNumber
{
    private static int findOddRepeatNumber(int[] A)
    {
        // xor properties
        // x^x = 0;
        // x^0 = x
        int xorSum = 0;
        for (int data: A)
        {
            xorSum = xorSum ^ data;
        }
        return xorSum;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 1, 2, 3, 2};
        int oddRepeatNo = findOddRepeatNumber(A);
        System.out.println("Odd Repeated Number is " + oddRepeatNo);
    }
}
