package com.jaradat.array;

import java.util.Arrays;

/*
Write a function rotate(arr[], d, n) that rotates arr[] of size n by d elements.
Sample Array
arr = [1,2,3,4,5,6,7,8]
Rotation of the above array by 2 will make an array
arr = [3,4,5,6,7,8,1,2]
 */
public class ArrayRotations {

    /*
        Using temp array
     */
    private static int[] rotate_1(int[] arr, int d) {
        int[] tmp = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            tmp[(arr.length - d + i) % (arr.length - 1)] = arr[i];
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotate_1(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 2)));
    }
}
