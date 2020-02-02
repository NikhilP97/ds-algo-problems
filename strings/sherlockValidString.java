/* Sherlock and the Valid String */

/**
 * Problem statement
 * 
 * Sherlock considers a string to be valid if all characters of the string appear the same number of times.
 * It is also valid if he can remove just 1 character at 1 index in the string, and the remaining characters will occur the same number of times.
 * Given a string s, determine if it is valid. If so, return YES, otherwise return NO.
 * 
 * For example, if s = "abc", it is a valid string because frequencies are {a:1, b:1, c:1}.
 * So is s = "abcc" because we can remove one c and have 1 of each character in the remaining string.
 * If s = "abccc" however, the string is not valid as we can only remove 1 occurrence of c. 
 * That would leave character frequencies of {a:1, b:1, c:2}.
 */

/**
 * Function Description
 * 
 * Complete the isValid function in the editor below. It should return either the string YES or the string NO.
 * isValid has the following parameter(s):
 * - s: a single string
 */

/**
 * Input Format
 * A single string s
 * 
 * Constraints
 * 1 <= s <= 10^5
 * Each char s[i] -E ascii [a-z]
 * 
 * Output Format
 * Print YES if string s is valid, otherwise, print NO.
 */

/**
 * My Code:
 * 
 * Time Complexity: O(n) where n is the size of the string.
 * Space Complexity: O(1) as the HashMaps do not grow with input string size.
 * 
 * Approach:
 * First I thought of ways the string could be valid.
 * There are 3 ways a string can be valid:
 * 1. If the frequency of each character is the same in the string
 * Example:
 * 4 4 4 4 4 4
 * a b c d e f
 * 
 * 2. If there is only 1 character whose frequency is more than the rest && the difference between them is exactly 1.
 * Example:
 * 2 2 2 2 3
 * a b c d e (valid)
 * --------------------
 * 2 2 2 2 4
 * a b c d e (invalid) since the differnce is more than 4 - 2 = 2 (more than 1)
 * 
 * 3. If there is only 1 character whose frequency is 1 & the rest of the characters have the same frequency.
 * 1 5 5 5 5
 * a b c d e (valid)
 * -------------------
 * 1 4 3 3 3
 * a b c d e (invalid) as the rest of the characters do not have the same occurences
 * 
 * Using the above logic, I used 2 HashMaps.
 * 1. First to map each letter to the number of times it occurred in the string (occurences)
 * 2. Second to map these occurences to the number of times they appeared across all letters.
 * 
 * I kept a track of the max number of times a letter occurred & correspondingly the frequency of this occurrence
 * I kept a track of the minimum as well.
 * Finally I used this data & plugged it into the above conditions.
 * 
 * If any condition matched, it was a valid string.
 * If if didn't, it wasn't a valid string.
 */

import java.util.*;

public class sherlockValidString {

    /**
     * Returns a string stating if the given string is valid according to the given conditions
     * @param inputStr The input string
     * @return "YES" if valid, "NO" if not valid
     */
    static String isValid(String inputStr) {
        HashMap<String, Integer> occurences = new HashMap<String, Integer>();
        HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        int strLen = inputStr.length();
        if (strLen == 1) {
            return "YES";
        }
        int maxFreqLetter = 1;
        int minFreqLetter = 1;
        int noOfMaxFreq = 0;
        int noOfMinFreq = 0;
        int distinctChars = 0;
        int frequency;
        for (int i = 0; i < strLen; i++) {
            String letter = Character.toString(inputStr.charAt(i));
            // Update letter <--> occurences mapping
            if (occurences.containsKey(letter)) {
                frequency = occurences.get(letter);
                int currFreq = freqMap.get(frequency);
                currFreq--;
                if (currFreq == 0) {
                    if (minFreqLetter == frequency) {
                        minFreqLetter = frequency + 1;
                    }
                    freqMap.remove(frequency);
                } else {
                    freqMap.put(frequency, currFreq);
                }
                frequency += 1;
                occurences.put(letter, frequency);
            } else {
                frequency = 1;
                distinctChars += 1;
                occurences.put(letter, 1);
            }

            // Update occurences <--> no of occurences mapping
            if (freqMap.containsKey(frequency)) {
                int currFreq = freqMap.get(frequency);
                currFreq++;
                freqMap.put(frequency, currFreq);
            } else {
                freqMap.put(frequency, 1);
            }

            // Update the minimum & maximum occurences
            if (frequency > maxFreqLetter) {
                maxFreqLetter = frequency;
            }
            if (frequency < minFreqLetter) {
                minFreqLetter = frequency;
            }
        }
        noOfMaxFreq = freqMap.get(maxFreqLetter);
        noOfMinFreq = freqMap.get(minFreqLetter);

        if (maxFreqLetter == minFreqLetter) return "YES";

        if (noOfMaxFreq == 1 && maxFreqLetter - minFreqLetter == 1) return "YES";

        if (noOfMinFreq == 1 && distinctChars - 1 == noOfMaxFreq) return "YES";

        return "NO";
    }

    public static void main(String[] args) {
        String inputString= "abcdefghhgfedecba";
        String result = isValid(inputString);
        System.out.println("String is valid ?: "+result);
    }
}
