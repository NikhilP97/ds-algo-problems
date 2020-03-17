/**
 * Closest Numbers
 * Java 8
 * Problem on HackerRank - https://www.hackerrank.com/challenges/closest-numbers/problem
 * 
 * Time Complexity: O(n log(n)) which is required to sort the array.
 * Space Complexity: O(n) where n is the list of numbers belonging to pairs which have the least difference.
 * 
 * Approach:
 * In order to find the smallest difference between the numbers, we sort the array. In this way, for a number,
 * the adjacent number will always give the smallest difference. We compare each difference with the current min value
 * & if its less or equal to the current difference we add both the numbers belonging to the pair to our result list.
 */

import java.util.*;

public class Solution {

    /**
     * Returns a list of numbers which are part of a pair (x, y) whose difference is the least 
     * among the given list of numbers. If the difference is the same, the numbers are appended
     * to the list.
     * @param arr The input array of numbers.
     * @return The array of numbers having the smallest difference.
     */
    static int[] closestNumbers(int[] arr) {
        Arrays.sort(arr);
        int minVal = 10000001;
        List<Integer> closestNums = new ArrayList<Integer>();
        for (int i = 0; i < arr.length-1; i++) {
            int currMin;
            // If both numbers are of the same sign, subtract them & then take absolute val
            if ((arr[i] > 0 && arr[i+1] > 0) || (arr[i] < 0 && arr[i+1] < 0)) {
                currMin = Math.abs(arr[i] - arr[i+1]);
            } else { // If numbers are of the opposite sign, take their absolute val and add them
                currMin = Math.abs(arr[i]) + Math.abs(arr[i+1]);
            }
            if (currMin < minVal) {
                closestNums.clear();
                minVal = currMin;
            }
            if (currMin == minVal) {
                closestNums.add(arr[i]);
                closestNums.add(arr[i+1]);
            }
        }
        int[] res = closestNums.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }

    public static void main(String[] args) {
        
        int[] arr = {5, 2, 3, 4, 1};

        int[] result = closestNumbers(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
