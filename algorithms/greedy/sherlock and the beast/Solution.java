/**
 * Sherlock and The Beast
 * Java 8
 * Problem on HackerRank - https://www.hackerrank.com/challenges/sherlock-and-the-beast/problem
 * 
 * Time Complexity: O(n) since we need to iterate through the each digit of the decent number
 * Space Complexity: O(n) since we store and build the string based on the length of the decent number.
 * 
 * Approach:
 * Build a string with all numbers as 5 equal to the length. We do this because we want the largest number.
 * Iterate from right to left of the string.
 * Check if the string satisfies the conditions of 5 and 3.
 * If not change the 5 at that location to 3 & check again.
 * By changing the numbers from right to left we ensure we have the largest number.
 * If reach the end of the loop that means the decent number does not exist.
 */

public class Solution {

    /**
     * Calculate the largest decent number given the length of the number
     * @param decentNumLen The length of the decent number.
     */
    static void decentNumber(int decentNumLen) {
        // start with all numbers as 5
        StringBuilder outputStr = new StringBuilder("");
        for (int i = 0; i < decentNumLen; i++) {
            outputStr.append("5");
        }
        // keep a track of 5's digit and 3's digits
        int noOf5 = decentNumLen;
        int noOf3 = 0;
        int i;
        for (i = decentNumLen-1; i >= 0; i--) {
            // check condition for 5 & 3 for length = 1 edge case
            if(noOf5 % 3 == 0 && noOf3 % 5 == 0) break;
            noOf3++;
            noOf5--;
            outputStr.setCharAt(i, '3');
            // check condition for 5 & 3 for length = n edge case
            if(noOf5 % 3 == 0 && noOf3 % 5 == 0) break;
        }
        String decentNum;
        if (i >= 0) {
            decentNum = outputStr.toString();
        } else {
            decentNum = "-1";
        }
        System.out.println(decentNum);
    }

    public static void main(String[] args) {
        int decentNumLen = 5;
        decentNumber(decentNumLen);
    }
}
