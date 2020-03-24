/**
 * Missing Numbers
 * Java 8
 * Problem on HackerRank: https://www.hackerrank.com/challenges/missing-numbers/problem
 * 
 * Time Complexity: O(n) where n is the size of brr which is the list with all numbers.
 * Space Complexity: O(n) where n is the size of brr which is the list with all numbers.
 * Note: We do not count the space for frequency arrays as they do not change with the size of the input
 *       & hence is constant space.
 * 
 * Approach:
 * The problem states that there are some numbers missing in arr. Since brr is a permutation of arr that means
 * all values will exist in brr. Hence we need to keep track of the frequency of numbers in arr & brr. Once we 
 * have the frequencies, all we need to do is compare them and if the frequency is brr is more than arr, we have 
 * found our missing number. Arrays are a great way to track frequencies of each number. Its given in the problem
 * that the difference between the max and min numbers is less than 100. We can use this as a offset for our array
 * so that we can keep the size small (only 101) rather than the max value of the number in brr.
 */

import java.util.*;

public class Solution {

    /**
     * Returns the missing numbers in arr which
     * @param arr The list which has missing numbers
     * @param brr The list which has all the numbers 
     * @return An array of missing numbers in ascending order
     */
    static int[] missingNumbers(int[] arr, int[] brr) {
        int[] freqArr = new int[101];
        int[] freqBrr = new int[101];
        int minVal = 10000;
        for (int i = 0; i < brr.length; i++) {
            if  (brr[i] < minVal) minVal = brr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            int curVal = arr[i];
            freqArr[curVal-minVal] += 1;
        }
        for (int i = 0; i < brr.length; i++) {
            int curVal = brr[i];
            freqBrr[curVal-minVal] += 1;
        }
        List<Integer> missingNumbersList = new ArrayList<Integer>();
        for (int i = 0; i < 101; i++) {
            if (freqBrr[i] > freqArr[i]) {
                missingNumbersList.add(i+minVal);
            }
        }
        int[] res = missingNumbersList.stream().mapToInt(Integer::intValue).toArray();
        return res;     
    }

    public static void main(String[] args) {
        int [] arr = {203, 204, 205, 206, 207, 208, 203, 204, 205, 206};
        int [] brr = {203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};

        int[] result = missingNumbers(arr, brr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
