/**
 * Manasa and Stones
 * Java 8
 * Problem on HackerRank - https://www.hackerrank.com/challenges/manasa-and-stones/problem
 * 
 * Time Complexity: O(n) as we calculate the last stone values which is always equal to n.
 * Space Complexity: O(1) as our storage requirements do not vary with input size.
 * 
 * Approach:
 * We need to calculate the values of the final stones. Given 2 values of consecutive differences,
 * we realize that the final values will be [min*(n-1), intermediate values, max*(n-1)]. Now
 * consider the following to find intermediate values.
 * for n = 3, a = 1, b = 2                                                                        
 *                                             0                   n = 1                               
 *                                           /   \                                                 
 *                                         1       2               n = 2                                
 *                                        / \     / \                                              
 *                                       2   3   3   4             n = 3                                 
 * 
 * As we notice, for a given row, the final values always differ by (b-a) = (2-1) = 1.
 * We also notice, the smallest value is (n-1)*a & largest value is (n-1)*b.
 * This is always true, because for a given stone, the next two values will always have a difference
 * equal to b-a. Hence we calculate the final stones by starting from the min value. Then incrementing
 * the min value by the difference until we reach the max value. In this way we find all the possible
 * values in O(n).
 */

public class Solution {

    /**
     * Calculates the possible values of the last stones, given the number of stones
     * and the differences between consecutive stones.
     * @param noOfStones The number of stones.
     * @param firstDiff The first difference between consecutive stones.
     * @param secondDiff The second difference between consecutive stones.
     * @return An array containing the values of the last stones.
     */
    static int[] stones(int noOfStones, int firstDiff, int secondDiff) {
        if (firstDiff == secondDiff) {
            return new int[]{(noOfStones-1)*firstDiff};
        }
        int minPath = Math.min(firstDiff, secondDiff);
        int maxPath = Math.max(firstDiff, secondDiff);
        int lastStoneMin = (noOfStones-1)*minPath;
        int lastStoneMax = (noOfStones-1)*maxPath;
        int difference = maxPath - minPath;
        int[] finalStones = new int[noOfStones];
        int index = 0;
        for (int stone = lastStoneMin; stone <= lastStoneMax; stone+=difference){
            finalStones[index] = stone;
            index++;
        }
        return finalStones;
    }

    public static void main(String[] args) {
        int noOfStones = 4;
        int firstDiff  = 10;
        int secondDiff = 100;
        int[] result = stones(noOfStones, firstDiff, secondDiff);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
