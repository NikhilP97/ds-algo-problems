/**
 * Largest Permutation
 * Java 8
 * Problem on HackerRank - https://www.hackerrank.com/challenges/largest-permutation/problem
 * 
 * Time Complexity: O(n) as we need to store the index values for the input array.
 * Space Complexity: O(n) since we need an array to keep track of the indexes.
 * 
 * Approach:
 * As we need to create the largest lexicographical value array, that means at arr[0] the highest
 * value which is n must be present. Next at arr[1] the next highest value arr[1] = n-1 must be
 * there and so on. In order to swap the 0th index value with nth value, we must know the index of
 * the nth value. Hence we use a index tracker array, to store the index, indexTracker[n] = the index
 * where n is stored in arr. Once we have the index tracker, based on the number of swaps, iterate the
 * array from 0 to n, and swap the values.
 */


public class Solution {

    /**
     * Creates the largest lexicographical value array that can be created by executing no more
     * than the limited number of swaps.
     * @param noOfSwaps The maximum number of swaps.
     * @param arr The input array.
     * @return The largest lexicographical value array.
     */
    static int[] largestPermutation(int noOfSwaps, int[] arr) {
        int[] indexTracker = new int[arr.length+1];
        for (int i = 0; i < indexTracker.length-1; i ++) {
            indexTracker[arr[i]] = i;
        }
        int arrSize = arr.length;
        int highestIndex = arrSize;
        int currIndex = 0;
        while (noOfSwaps > 0 && currIndex < arrSize && highestIndex > 0) {
            int currIndexVal = arr[currIndex];
            int highestIndexVal = arr[indexTracker[highestIndex]];
            if (currIndexVal < highestIndexVal) {
                swap(arr, currIndex, indexTracker[highestIndexVal]);
                swap(indexTracker, currIndexVal, highestIndexVal);
                noOfSwaps--;
            }
            highestIndex--;
            currIndex++;
        }
        return arr;
    }

    /**
     * Swaps the values of an array given two indexes.
     * @param arr The array whose values need to be swapped.
     * @param index1 The first index.
     * @param index2 The second index.
     */
    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        int noOfSwaps = 1;
        int[] arr = {4, 2, 3, 5, 1};
        int[] result = largestPermutation(noOfSwaps, arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
