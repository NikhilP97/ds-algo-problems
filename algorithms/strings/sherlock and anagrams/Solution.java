/**
 * Sherlock and Anagrams
 * Java 8
 * Problem on HackerRank - https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
 * 
 * Time Complexity: O(s^3) where s is the size of the input string. The time complexity is O(s^3) since
 * we iterate over all O(s^2) substrings of input string and for each substring we compute its signature
 * in O(s) time.
 * Space Complexity: O(1) since the hashmap would max have 26 different keys (a-z) in the worst case.
 * 
 * Approach:
 * 
 * The idea is to iterate through the sub string from length 1 to n. So for a string s = "aba", first take
 * substring length as 1, hence we get 'a', 'b', 'a'. Next take length as 2, 'ab', 'ba' and finally length
 * as 3 (3=n) 'abc'. Now for the list of substrings, sort each substring is ascending order. So 'ab' will
 * become 'ab' and 'ba' will become 'ab'. Using 'ab' as the key, count the number of times this string ('ab')
 * occurs. Store this value in a HashMap. Now finally to calculate the number of pairs of anagrams, iterate
 * through the HashMap, if the value is 1 that means no other anagram was there. If its greater than 1 (2, 3 ..)
 * we can calculate the number of pairs using (n * n+1 ) / 2. Here n = value-1. For example if we have a value of
 * 3 then n = 2. Hence number of pairs = ( 2 * 2+1 ) / 2 = 3. So we get 3 pairs of anagrams. Add this to the 
 * total sum and we get the total pairs of anagrams in the sub string.
 */

import java.util.*;

public class Solution {

    /**
     * Calculates the number of pairs of anagrams formed among the substrings of the input.
     * @param s The input string
     * @return The number of pairs of anagrams.
     */
    static int sherlockAndAnagrams(String s) {
        int n = s.length();
        int anagrams = 0;
        for (int i = 1; i <= n; i++) {
            int j = 0;
            HashMap<String, Integer> freq = new HashMap<>();
            while (j < n) {
                String sub;
                if (j+i > n) sub = s.substring(j);
                else sub = s.substring(j, j+i);
                char[] letters = sub.toCharArray();
                Arrays.sort(letters);
                String key = new String(letters);
                if (freq.containsKey(key)) {
                    int curr = freq.get(key);
                    freq.put(key, ++curr);
                }
                else freq.put(key, 1);
                j++;
            }
            for (Map.Entry<String,Integer> entry : freq.entrySet()) {
                int v = entry.getValue();
                v--;
                if (v > 0) {
                    int sum = (v * (v+1)) / 2;
                    anagrams+=sum;
                }
            }
        }
        return anagrams;
    }

    public static void main(String[] args) {
        String s = "cdcd";
        int pairs = sherlockAndAnagrams(s);
        System.out.println("The number of anagram pairs are: "+pairs);
    }
}
