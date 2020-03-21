/**
 * Maximizing XOR
 * Java 8
 * Problem on HackerRank - https://www.hackerrank.com/challenges/maximizing-xor/problem
 * 
 * Time Complexity: O(n^2) since we for every value of l, we loop from l to r.
 * Space Complexity: O(1) we only need to keep track of the max val.
 * 
 * Approach:
 * I used a brute force method. For every value from l to r, find the XOR value from l to r,
 * compare it with the max value and return the max val at the end.
 * 
 * Note: There was a better solution in the editorial, which I have mentioned below.
 */
public class Solution {

    /**
     * Calculates the maximum value of XOR given 2 numbers & the condition where,
     * l<=a<=b<=r.
     * @param l The lower integer.
     * @param r The higher integer.
     * @return The max value among the combinations.
     */
    static int maximizingXor(int l, int r) {
        int max = 0;
        for (int i = l; i <=r; i++) {
            for (int j = i; j <= r; j++) {
                int curr = i ^ j;
                if (curr > max) max = curr;
            }
        }
        return max;
    }

    /**
     * Editorial Solutions
     * 
     * def maxXOR(L,R):
        P = L^R
        ret = 1
        while(P): # this one takes (m+1) = O(logR) steps
            ret <<= 1
            P >>= 1
        return (ret - 1)
     * 
     * 
     *  v = l ^ r
        v |= v >> 1
        v |= v >> 2
        v |= v >> 4
        v |= v >> 8
        v |= v >> 16
        print v
     */

    public static void main(String[] args) {
        int l = 11;
        int r = 100;
        int maxXOR = maximizingXor(l, r);
        System.out.println("The Maximum XOR value is: "+maxXOR);
    }
}
