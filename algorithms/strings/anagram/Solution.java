/**
 * Anagram
 * Java 8
 * Problem on HackerRank - https://www.hackerrank.com/challenges/anagram/problem
 * 
 * Time Complexity: O(s) where s is the size of the string
 * Space Complexity: O(1) as we at most store 26 keys (a-z) in the hashmap however large the input is.
 * 
 * Approach:
 * First we check the size of the string. If it is odd, then we return -1 as we cannot split it into 2
 * substrings of equal length. If the size is even, then we split the strings into 2 parts. We iterate
 * through the second part and note down the frequency of each character using a HashMap. After that,
 * we iterate through the first part and check if the characters are present in the HasMap. If they are
 * not then we need to change the current character so increment the counter by 1. If it is present then
 * we reduce the frequency by 1, until it becomes 0 in which case we remove it from the HashMap. Now the 
 * next time we get the same character we don't find it in the HashMap and increase the counter by 1.
 */

import java.util.*;

public class Solution {

    /**
     * Calculates the number of changes required between the 2 substrings to form an anagram.
     * @param s The input string.
     * @return The number of changes required to make the first substring an anagram of the second.
     */
    static int anagram(String s) {
        int n = s.length();
        if (n % 2 != 0) return -1;
        int half = n/2;
        String second = s.substring(half);
        char[] charArr = second.toCharArray();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c: charArr) {
            if (map2.containsKey(c)) {
                int cur = map2.get(c);
                map2.put(c, ++cur);
            } else map2.put(c, 1);
        }
        String first = s.substring(0, half);
        int changes = 0;
        for (int i = 0; i < first.length(); i++) {
            char curr = first.charAt(i);
            if (map2.containsKey(curr)) {
                int freq = map2.get(curr);
                freq--;
                if (freq <= 0) map2.remove(curr);
                else map2.put(curr, freq);
            } else {
                changes++;
            }
        }
        return changes;
    }

    public static void main(String[] args) {
        String s = "xaxbbbxx";
        int noOfChanges = anagram(s);
        System.out.println("The number of changes required are: "+noOfChanges);
    }
}
