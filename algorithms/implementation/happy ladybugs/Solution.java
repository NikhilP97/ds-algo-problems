/**
 * Happy Ladybugs
 * Java 8
 * Problem on HackerRank - https://www.hackerrank.com/challenges/happy-ladybugs/problem
 * 
 * Time Complexity: O(n) since we need to iterate each character in the string & store its
 * color frequency.
 * Space Complexity: O(1) since we only have to store colors from A-Z & it does not vary with
 * input size.
 * 
 * Approach:
 * In order to determine happy ladybugs we need to calculate the following:
 * 1. How many empty positions are present on the board.
 * 2. The occurrence of each type of color of the lady bugs.
 * 
 * In order to determine happy ladybugs we need to check for the following conditions.
 * 1. Iterate through the string and check if in the current positions the lady bugs are happy or
 *    not. If happy return "YES".
 * 2. If not happy, check the number of empty positions.
 * 3. If empty positions are zero, that means we can't move them around, so return "NO".
 * 4. If we reach here, means that the ladybugs are not happy but there are empty locations.
 *    We can move the lady bugs around if we have more 1 or more locations free. Since we have reached
 *    here that means there is 1 or more empty locations.
 * 5. Now we only need to check the occurences of each color. If the occurrence == 1, then we can't pair
 *    it with any other. So even if we get 1 such color whose occurrence == 1, return "NO".
 * 6. If our code has reached here, it means for each color, there is more than 1 occurrence. Hence we can
 *    move the ladybugs around and return "YES".
 */
public class Solution {

    /**
     * Determines if the lady buys are happy based on the board conditions.
     * @param board The board conditions.
     * @return "YES" if all ladybugs are happy, "NO" otherwise
     */
    static String happyLadybugs(String board) {
        int noOfEmptyPos = 0;
        int[] freqMap = new int[26];
        boolean isLayBugHappy = true;        
        int n = board.length();
        for (int i = 0; i < n; i++) {
            char curr = board.charAt(i);
            if (curr == '_') {
                noOfEmptyPos++;
                continue;
            }
            freqMap[curr-'A']++;
            char leftNeighbor;
            if (i > 0) leftNeighbor = board.charAt(i-1);
            else leftNeighbor = '_';
            char rightNeighbor;
            if (i < n-1) rightNeighbor = board.charAt(i+1);
            else rightNeighbor = '_';
            if (leftNeighbor != curr && rightNeighbor != curr) {
                isLayBugHappy = false;
            }
        }
        if (isLayBugHappy) return "YES";
        if (noOfEmptyPos == 0) return "NO";
        for (int i = 0; i < 26; i++) {
            if (freqMap[i] == 1) return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        String board = "DD__FQ_QQF";
        String ladyBugsHappy = happyLadybugs(board);
        System.out.println("Are the ladybugs happy?: "+ladyBugsHappy);
    }
}
