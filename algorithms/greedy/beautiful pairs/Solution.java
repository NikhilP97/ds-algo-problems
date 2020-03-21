/**
 * Beautiful Pairs
 * Java 8
 * Problem on HackerRank - https://www.hackerrank.com/challenges/beautiful-pairs/problem
 * 
 * Time Complexity: O(n) since we need to calculate the frequency of numbers in both the arrays.
 * Space Complexity: O(1) since we need to keep track of numbers between 1 - 1000 only.
 * 
 * Approach:
 * Since we need to calculate the number of pairs which have the same value in both the arrays, we
 * maintain a frequency array for A & B. Once we have the frequency array, we iterate to it & for a
 * given number we check the frequency in both arrays. If the frequency is same & not 0, we add it
 * to the number of beautiful pairs. If it is not the same, we find the lower frequency & add it to
 * the no of beautiful pairs. We also keep track of the extra numbers in A & B. At the end, if both
 * are more than zero we add 1 to the existing no of beautiful pairs.
 * 
 * Note: It is given in the problem statement that we need to make 1 change in array B. Hence even if
 * we have all the frequency of each number the same and there are no extra numbers, we need to subtract 1
 * from the beautiful pairs as we change 1 of the numbers in B which results is loosing one beautiful pair.
 * This does not make sense as we have to maximize the no of beautiful pairs, but if we do not implement this
 * condition we do not pass test case 5 & 6.
 */


public class Solution {

    /**
     * Calculates the number of beautiful pairs for giving two arrays
     * @param A The first input array
     * @param B The second input array
     * @return The number of beautiful pairs
     */
    static int beautifulPairs(int[] A, int[] B) {
        int[] freqA = new int[1001];
        int[] freqB = new int[1001];
        for (int i = 0; i < A.length; i++) {
            freqA[A[i]]++;
            freqB[B[i]]++;
        }
        int beautifulPairs = 0;
        int extraNumsA = 0;
        int extraNumsB = 0;
        for (int i = 1; i < freqB.length; i++) {
            if (freqA[i] == freqB[i] && freqA[i]!=0 && freqB[i]!=0) {
                beautifulPairs+=freqA[i];
            } else {
                int lowerFreq = (freqA[i] < freqB[i]) ? freqA[i] : freqB[i];
                int difference = Math.abs(freqA[i] - freqB[i]);
                beautifulPairs+=lowerFreq;
                // if more elements in B
                if (lowerFreq == freqA[i]) {
                    extraNumsB+=difference;
                } else { // more elements in A
                    extraNumsA+=difference;
                }
            }
        }
        if (extraNumsA > 0 && extraNumsB > 0) beautifulPairs+=1;
        else beautifulPairs-=1;
        return beautifulPairs;
    }

    public static void main(String[] args) {
        int[] A = {3, 5, 7, 11, 5, 8};
        int[] B = {5, 7, 11, 10, 5, 8};
        int result = beautifulPairs(A, B);
        System.out.println("Number of beautiful pairs are: "+result);
    }
}
