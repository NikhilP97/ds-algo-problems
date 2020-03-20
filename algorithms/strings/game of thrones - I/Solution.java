/**
 * Game of Thrones - I
 * Java 8
 * Problem on HackerRank - https://www.hackerrank.com/challenges/game-of-thrones/problem
 * 
 * Time Complexity: O(n) where n is the length of the input string.
 * Space Complexity: O(1) since we will at most store 26 characters & it does not depend on
 * the input size
 * 
 * Approach:
 * A palindrome has the property such that only 1 character in the string can have an odd frequency
 * at most. We keep track of each characters frequency and have a counter to track odd characters.
 * At the end if we have more than 1 character with odd frequency, we cannot make a palindrome of the
 * input string.
 */
import java.util.*;

public class Solution {

    /**
     * Determines whether an anagram of the input string can be a palindrome or not.
     * @param keyString The input string
     * @return "YES" if an anagram exists such that it is a palindrome. "NO" otherwise.
     */
    static String gameOfThrones(String keyString) {
        HashMap<Character, Integer> freqMap = new HashMap<Character, Integer>();
        int noOfOddChars = 0;
        for (int i = 0; i < keyString.length(); i++) {
            char curr = keyString.charAt(i);
            if (freqMap.containsKey(curr)) {
                int currFreq = freqMap.get(curr);
                currFreq++;
                freqMap.put(curr, currFreq);;
                if (currFreq % 2 == 0) noOfOddChars--;
                else noOfOddChars++;
            } else {
                freqMap.put(curr, 1);
                noOfOddChars++;
            }
        }
        if (noOfOddChars > 1) return "NO";
        return "YES";
    }

    public static void main(String[] args) {
        String key = "cdcdcdcdeeeef";
        String result = gameOfThrones(key);
        System.out.println("Will King Robert be able to stop the attack? : "+result);
    }
}
