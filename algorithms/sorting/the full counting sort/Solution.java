
/**
 * The Full Counting Sort
 * Java 8
 * Problem on HackerRank - https://www.hackerrank.com/challenges/countingsort4/problem
 * 
 * Time Complexity: O(n) where n is the size of the number of integer/string pairs in the array.
 * Space Complexity: O(n) where n is the size of the number of integer/string pairs in the array.
 * 
 * Approach:
 * Although the problem requires you to use counting sort, a better way is to use a HashMap
 * to maintain the integer <--> strings mapping. In this way we are able to get a stable sort since
 * the strings are appended to the map in the order they are taken from the input. Once the Map is created
 * we can simply iterate through it in ascending order and print the result.
 * Note: I have used string builder specifically and directly in the main function, as using the pre generated
 * code would timeout in the test cases even though my solution was correct. Using System.out.println also times
 * out in the test cases.
 */

import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        HashMap<Integer, StringBuilder> hashMap = new HashMap<Integer, StringBuilder>();
        for (int i = 0; i < n; i++) {
            String[] tmp = in.readLine().split(" ");
            int value = Integer.parseInt(tmp[0]);
            String strVal = tmp[1];
            if (i < n / 2) {
                strVal = "-";
            }
            if (hashMap.containsKey(value)) {
                StringBuilder tempBuilder = hashMap.get(value);
                tempBuilder.append(strVal + " ");
                hashMap.put(value, tempBuilder);
            } else {
                StringBuilder str = new StringBuilder(strVal + " ");
                hashMap.put(value, str);
            }
        }

        StringBuilder str = new StringBuilder();
        hashMap.entrySet().forEach(entry -> {
            StringBuilder currString = entry.getValue();
            str.append(currString.toString());
        });
        System.out.print(str.toString());
        in.close();
    }
}
