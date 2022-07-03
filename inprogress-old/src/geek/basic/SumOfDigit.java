package geek.basic;
/*
https://www.geeksforgeeks.org/program-for-sum-of-the-digits-of-a-given-number/
Given a number, find sum of its digits.

    Examples :

        Input : n = 687
        Output : 21

        Input : n = 12
        Output : 3
 */
public class SumOfDigit {
    public static int sumOfDigit(int n) {
        int result = 0;
        while (n != 0) {
            result += n % 10;
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigit(123));
        System.out.println(sumOfDigit(12345));
        System.out.println(sumOfDigit(0));
    }
}
