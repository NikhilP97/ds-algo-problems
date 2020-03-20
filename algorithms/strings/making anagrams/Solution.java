/**
 * Making Anagrams
 * Java 8
 * Problem on HackerRank - https://www.hackerrank.com/challenges/making-anagrams/problem
 * 
 * Time Complexity: O(n) where n is the size of the input strings.
 * Space Complexity: O(1) since we need to store the frequency of only 26 chars.
 * 
 * Approach:
 * Maintain a frequency of chars array for both the input strings. Then iterate through the frequency
 * array and if the frequency of a char is not the same for both, find the difference and add it to
 * the counter of no of deletions.
 */

public class Solution {

    /**
     * Determines the number of deletions required to be made in either of the input strings
     * to make them an anagram of each other.
     * @param s1 The first input string.
     * @param s2 The second input string.
     * @return The number of deletions required.
     */
    static int makingAnagrams(String s1, String s2) {
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char curr = s1.charAt(i);
            int charPos = curr - 'a';
            s1Freq[charPos]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            char curr = s2.charAt(i);
            int charPos = curr - 'a';
            s2Freq[charPos]++;
        }
        int noOfDeletions = 0;
        for (int i = 0; i < s1Freq.length; i++) {
            int extraChars = Math.abs(s1Freq[i] - s2Freq[i]);
            noOfDeletions+=extraChars;
        }
        return noOfDeletions;
    }

    public static void main(String[] args) {        
        String s1 = "cde";
        String s2 = "abc";
        int result = makingAnagrams(s1, s2);
        System.out.println("Number of deletions to make an anagram are: "+result);
    }
}
