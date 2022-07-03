package geek.basic;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class ReverseAnArray {
    /*
    https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
    Given an array (or string), the task is to reverse the array/string.

    Examples :


        Input  : arr[] = {1, 2, 3}
        Output : arr[] = {3, 2, 1}

        Input :  arr[] = {4, 5, 1, 2}
        Output : arr[] = {2, 1, 5, 4}




     */

    static int[] reverse_iterative(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            arr[i] ^= arr[arr.length - i - 1];
            arr[arr.length - i - 1] ^= arr[i];
            arr[i] ^= arr[arr.length - i - 1];
        }
        return arr;
    }

    static int[] reverse_recursion(int[] arr) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < arr.length; i++)
            stack.addFirst(arr[i]);
        for (int i = 0; i < arr.length; i++)
            arr[i] = stack.pollFirst();
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverse_iterative(new int[]{1, 2, 3, 4, 5, 6})));
        System.out.println(Arrays.toString(reverse_iterative(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(reverse_recursion(new int[]{1, 2, 3, 4, 5, 6})));
        System.out.println(Arrays.toString(reverse_recursion(new int[]{1, 2, 3, 4, 5})));
    }
}
