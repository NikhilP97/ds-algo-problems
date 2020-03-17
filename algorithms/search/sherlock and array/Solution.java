/**
 * Sherlock and Array
 * Java 8
 * Problem on HackerRank - https://www.hackerrank.com/challenges/sherlock-and-array/problem
 * 
 * Time Complexity: O(n) where n is the size of array of integers.
 * Space Complexity: O(n) where n is the size of sum array size which is equal to the array of integers.
 * 
 * Approach:
 * The idea is to keep a track of the sum all the numbers till the ith index. So the final index will have 
 * the sum of all the numbers in the integer. Once we have the sum, we need to iterate the array and check if
 * the sum of ith index -1 is equal to the total sum - the ith index sum. If at any point this condition satisfies
 * return "YES" else at the end return "NO".
 */

import java.util.*;

public class Solution {

    /**
     * Checks whether the given array has an element such that the sum of all elements to the left
     * is equal to the sum of all elements to the right.
     * @param arr The sequence of numbers to check.
     * @return "YES" if satisfies the condition else "NO"
     */
    static String balancedSums(List<Integer> arr) {
        int[] sum = new int[arr.size()];
        sum[0] = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            sum[i] = sum[i-1] + arr.get(i);
        }
        int leftSumFor0thIndex = 0;
        int rightSumFor0thIndex = sum[sum.length-1] - sum[0];
        if (leftSumFor0thIndex == rightSumFor0thIndex) {
            return "YES";
        }
        for (int i = 1; i < sum.length; i++) {
            int leftSum = sum[i-1];
            int rightSum = sum[sum.length-1] - sum[i];
            if (leftSum == rightSum) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>(List.of(5, 6, 8, 11));
        String result = balancedSums(arr);
        System.out.println("Is the array balanced: "+result);
    }
}
