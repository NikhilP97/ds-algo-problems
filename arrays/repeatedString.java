/* Repeated strings problem */

/**
 * Problem Statement
 * 
 * Lilah has a string, s, of lowercase English letters that she repeated infinitely many times.
 * Given an integer, n, find and print the number of letter a's in the first n letters of Lilah's infinite string.
 * For example, if the string s='abcac' and n = 10, the substring we consider is abcacabcac,
 * the first 10 characters of her infinite string. There are 4 occurrences of a in the substring.
 */

/**
 * Function Description
 * 
 * Complete the repeatedString function in the editor below. It should return an integer representing the number of occurrences
 * of a in the prefix of length n in the infinitely repeating string.
 * 
 * repeatedString has the following parameter(s):
 * s: a string to repeat
 * n: the number of characters to consider
 */

/**
 * Input Format
 * 
 * The first line contains a single string, s.
 * The second line contains an integer, n.
 * 
 * Constraints
 * 
 * 1 <= s <= 100
 * 1 <= n <= 10^12
 * For 25% of the test cases, n <= 10^6.
 * 
 * Output Format
 * 
 * Print a single integer denoting the number of letter a's in the first n letters of the
 * infinite string created by repeating s infinitely many times.
 * 
 * Sample Input 0
 * aba
 * 10
 * 
 * Sample Output 0
 * 7
 * 
 * Sample Input 1
 * a
 * 1000000000000
 * 
 * Sample Output 1
 * 1000000000000
 * 
 * Explanation 1
 * Because all of the first n = 1000000000000 letters of the infinite string are a, we print 1000000000000 on a new line.
 * 
 */


public class repeatedString {

    /**
     * Returns the number of 'a' letters in the infinite string upto the first N letters
     * @param inputString The sub string which is repeated infinitely
     * @param firstNLetters The count upto which we have to find letter 'a' in the string 
     * @return The total count of letter 'a' in the string upto N
     */
    static long countRepeatedString(String inputString, long firstNLetters) {
        int strLen = inputString.length();
        long noOfwholeSubStrings = firstNLetters / strLen;
        long offset = firstNLetters % strLen;
        long countOfAInOffsetString = 0;
        int countOfAInInputString = 0;
        for (int i=0; i < inputString.length(); i++) {
            if(inputString.charAt(i) == 'a'){
                if (i < offset) {
                    countOfAInOffsetString++;
                }
                countOfAInInputString++;
            }
        }
        long totalCountOfAInWholeSubStrings = noOfwholeSubStrings * countOfAInInputString;
        return countOfAInOffsetString + totalCountOfAInWholeSubStrings;
    }

    public static void main(String[] args) {
        long firstNLetters = 10;
        String lilahsString = "aba";
        long noOfAInInfinteString = countRepeatedString(lilahsString, firstNLetters);
        System.out.println("No of A letters are: "+noOfAInInfinteString);
    }
}
