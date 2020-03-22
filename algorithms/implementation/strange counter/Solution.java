/**
 * Strange Counter
 * Java 8
 * Problem on HackerRank - https://www.hackerrank.com/challenges/strange-code/problem
 * 
 * Time Complexity: O(n) where n is the value of the time we need to find.
 * Space Complexity: O(1) since the solution does not require more space based on the input.
 * 
 * Approach:
 * The brute force approach would be to iterate till t, incrementing the value v according to the
 * conditions. This would however fail for very large inputs.
 * To get the value at time equal to t, we need to find the block in which t is present.
 * (Refer the problem statement to know what block mean, they have shown it visually)
 * So we need to calculate the upper bound for each iteration, if it is less than t, continue.
 * If the upper bound is more than t, use the start time for that block as an offset and calculate
 * the required value at time t.
 */

public class Solution {

    /**
     * Given the counter sequence, it calculates the value for time t.
     * @param t The time for which the value must be calculated.
     * @return The value at time t.
     */
    static long strangeCounter(long t) {
        long startTime = 1;
        long startValue = 3;
        long endTime = startTime+startValue-1;
        while (t > endTime) {
            startTime = endTime+1;
            startValue = startValue*2;
            endTime = startTime+startValue-1;
        }
        return startValue-(t-startTime);
    }

    public static void main(String[] args) {
        long t = 4;
        long value = strangeCounter(t);
        System.out.printf("At time t: %d, value: %d \n", t, value);
    }
}
