package practice;

/*
Write a program to calculate pow(x,n)
Given two integers x and n, write a function to compute x^n.
We may assume that x and n are small and overflow doesn’t happen.

Input : x = 2, n = 3
Output : 8

Input : x = 7, n = 2
Output : 49

 */
public class CalculatePowerOf2Numbers {

    private static float calculatePow(int x, int y) {
        if (y == 0)
            return 1;
        float result = calculatePow(x, y / 2);
        if (y % 2 == 0)
            return result * result;
        else {
            if (y > 0)
                return result * result * x;
            else
                return result * result / x;
        }
    }

    public static void main(String[] args) {
        System.out.println(calculatePow(2, 2)); // 4
        System.out.println(calculatePow(2, 3)); // 8
        System.out.println(calculatePow(2, 5)); // 32
        System.out.println(calculatePow(2, -3)); // .125
        System.out.println(calculatePow(2, -5)); // .03125
    }
}
