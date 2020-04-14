/**
 * Perform String Shifts
 * Java 8
 * Problem on LeetCode - https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3299
 * This problem is part of 30 day code challenge for April 2020.
 * 
 * Time Complexity: O(n) where n is the number of operations.
 * Space Complexity: O(s) where s is the size of the input string.
 * 
 * Approach:
 * We could follow a simple approach by executing each operation as we see it. I initially thought of 2 
 * optimizations. The first is if we have the number of shifts (d) greater than the size of the string
 * then we can take - noOfShifts % lengthOfStr. This is done because if get shifts of the size of the 
 * string it will always be the original. The 2nd optimization was if the noOfShifts > lengthOfStr/2
 * then we can reverse the direction and do lengthOfStr - noOfShifts, number of shifts. For example,
 * if we have a string "abcdefghij" which has length 10, if we are asked to shift left by 9, we could
 * shift it left by 1.
 * 
 * Note: After reading the hints, I noticed we can optimize the solution even more. Check OptimizedSolution.java
 * for more.
 */

class Solution {
    
    private String leftRotate(String str, int d) {
        String ans = str.substring(d) + str.substring(0, d); 
        return ans; 
    }

    private String rightRotate(String str, int d) { 
        return leftRotate(str, str.length() - d); 
    }

    private int getOppDir(int dir) {
        if (dir == 0) return 1;
        return 0;
    }

    private String rotateString(String sb, int dir, int amt) {
        if (amt > 0) {
            int len = sb.length();
            if (amt > len/2) {
                dir = getOppDir(dir);
                amt = len - amt;
            }
            if (dir == 0) return leftRotate(sb, amt);
            return rightRotate(sb, amt);
        }
        return sb;
    }

    public String stringShift(String s, int[][] shift) {
        int n = shift.length;
        int len = s.length();
        for (int i = 0; i < n; i++) {
            int dir = shift[i][0];
            int amt = shift[i][1];
            if (amt < len) s = rotateString(s, dir, amt);
            else s = rotateString(s, dir, amt%len);
        }
        return s;
    }

    public static void main(String[] args) {
        int[][] operations = new int[4][2];
        operations[0] = new int []{1,1};
        operations[1] = new int []{1,1};
        operations[2] = new int []{0,2};
        operations[3] = new int []{1,3};
        String input = "abcdefg";
        Solution solution = new Solution();
        String shiftedStr = solution.stringShift(input, operations);
        System.out.println("The shifted string is: "+shiftedStr);
    }
}