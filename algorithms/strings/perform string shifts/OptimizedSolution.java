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
 * Instead of rotating the string at every operation, we calculate the total number of left shift
 * operations and right shift operations. Since left operations cancel right operations and vice
 * versa, we take the difference left - right. If left > right that means we need to shift the string
 * left by (left-right) otherwise if right > left, shift right by the difference.
 * 
 * Note: My original approach can be found in Solution.java
 */

class OptimizedSolution {
    
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
        int left = 0, right = 0, dir, amt;
        for (int i = 0; i < n; i++) {
            dir = shift[i][0];
            amt = shift[i][1];
            if (dir == 0) left += amt;
            else right += amt;
        }
        dir = left > right ? 0 : 1;
        amt = Math.abs(left-right);
        amt = amt < len ? amt : amt%len;
        s = rotateString(s, dir, amt); // ***Perform only once string rotation
        return s;
    }

    public static void main(String[] args) {
        int[][] operations = new int[4][2];
        operations[0] = new int []{1,1};
        operations[1] = new int []{1,1};
        operations[2] = new int []{0,2};
        operations[3] = new int []{1,3};
        String input = "abcdefg";
        OptimizedSolution solution = new OptimizedSolution();
        String shiftedStr = solution.stringShift(input, operations);
        System.out.println("The shifted string is: "+shiftedStr);
    }
}