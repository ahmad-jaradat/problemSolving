package practice;

/*
There are 2 sorted arrays A and B of size n each.
Write an algorithm to find the median of the array obtained after merging the above 2 arrays(i.e. array of length 2n).
The complexity should be O(log(n)).

Sample Input :
arr1 = [1, 12, 15, 26, 38]
arr2 = [2, 13, 17, 30, 45]

Expected Output : 16

[1, 2, 12, 13, 15, 17, 26, 30, 38, 45]
The array have even number of elements, the median is (15 + 17) / 2 = 16
 */
public class MedianOf2SortedArray {

    private static int medianOf2Array(int[] arr1, int[] arr2) {
        int totalSize = arr1.length + arr2.length;
        int medianIndex = totalSize / 2;
        if (totalSize % 2 == 0)
            return (elementAt(arr1, arr2, medianIndex) + elementAt(arr1, arr2, medianIndex + 1)) / 2;
        else
            return elementAt(arr1, arr2, medianIndex);
    }

    private static int elementAt(int[] arr1, int[] arr2, int index) {
        if (index > arr1.length - 1)
            return arr2[index - arr1.length];
        else
            return arr1[index];
    }

    public static void main(String[] args) {
        System.out.println(medianOf2Array(new int[]{1, 12, 15, 26, 38}, new int[]{2, 13, 17, 30, 45}));
    }
}
