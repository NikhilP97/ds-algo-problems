/**
 * Permuting Two Arrays
 * Java 8
 * Problem on HackerRank - https://www.hackerrank.com/challenges/two-arrays/problem
 * 
 * Time Complexity: O(n log(n)) which is required to sort the two arrays.
 * Space Complexity: O(n) where n is the size of the input arrays.
 * 
 * Approach:
 * We have to find a permutation between 2 arrays such that for a given element in A there exists another
 * element in B such A[i]+B[i]>=k. This means if we take an element in A, the max value among elements in
 * B must exist such that it is >= A[i] - k. To achieve this we sort both the arrays, then we start from 
 * the smallest element in A & compare it with the largest element in B. If their sum is >= k, we move on
 * compare the next smallest element in A to the next largest element in B. By doing this we ensure that
 * the tightest bounds are checked and any other combination will always be true.
 * 
 * Note: Instead of converting int[] to Integer to sort in descending order, I have used reverse indexing as
 * converting the primitive (4 bytes) to Integer (16 bytes) would waste unnecessary memory.
 */

import java.util.*;

public class Solution {

    /**
     * Determines whether a permutation exist among the two arrays such that
     * A'[i]+B'[i] >= k
     * @param k The value above which the sum must be greater or equal to.
     * @param A The first input array
     * @param B The second input array
     * @return "YES" if the permutation exists. "NO" otherwise
     */
    static String twoArrays(int k, int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int arrLen = B.length-1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] + B[arrLen-i] < k) return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        
        int[] A = {1, 2, 2, 1};
        int[] B = {3, 3, 3, 4};
        int k = 5;
        String result = twoArrays(k, A, B);
        System.out.println("Does a permutation exist ?: "+result);
    }
}
