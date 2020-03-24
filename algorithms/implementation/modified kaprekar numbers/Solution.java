/**
 * Modified Kaprekar Numbers
 * Java 8
 * Problem on HackerRank - https://www.hackerrank.com/challenges/kaprekar-numbers/problem
 * 
 * Time Complexity: O(n) where n is the range from the lower bound to upper bound.
 * Space Complexity: O(1) we use constant space for all operations & it does not vary by the input range.
 * 
 * Approach:
 * Following are the steps to determine if a number is a Kaprekar number or not.
 * 1. Calculate the square of the number.
 * 2. Check the length of the square, if they are not the same, it is a single digit number. All single
 *    digit numbers except 1 are not Kaprekar  umbers.
 * 3. Split the squared number in to, 2 integer, left & right. If left + right = original number then it
 *    is a Kaprekar number.
 * 
 * Note:
 * One edge case is when we get the number 1, so we directly print it.
 * Another thing to note about the problem is that we need to use long, to store the squared values. If we
 * store the squared values in int then we have loss of data & our left and right values are not as expected.
 */


public class Solution {

    /**
     * Prints the kaprekar numbers from a lower index to the upper index
     * @param lower The lower index number.
     * @param higher The upper index number.
     */
    static void kaprekarNumbers(int lower, int higher) {
        boolean notValid = true;
        for (int num = lower; num <=higher; num++) {
            long squaredNum = (long) Math.pow(num, 2);
            String numStr = Integer.toString(num);
            String squareStr = Long.toString(squaredNum);
            if (num == 1) {
                System.out.printf("1 ");
                notValid = false;
            }
            if (numStr.length() != squareStr.length()) {
                int left = Integer.parseInt(squareStr.substring(0, squareStr.length()/2));
                int right = Integer.parseInt(squareStr.substring(squareStr.length()/2, squareStr.length()));
                int sum = left + right;
                if (sum == num) {
                    System.out.printf("%d ", num);
                    notValid = false;
                }
            }
        }
        if (notValid) {
            System.out.print("INVALID RANGE");
        }
    }

    public static void main(String[] args) {
        int lower = 1;
        int higher = 99999;
        kaprekarNumbers(lower, higher);
    }
}
