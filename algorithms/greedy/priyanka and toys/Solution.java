/**
 * Priyanka and Toys
 * Java 8
 * Problem on HackerRank - https://www.hackerrank.com/challenges/priyanka-and-toys/problem
 * 
 * Time Complexity: O(n) since we need to iterate over each value to map the visited array
 * Space Complexity: O(1) since the visited array size does not vary on the number of orders.
 * 
 * Approach:
 * I used a naive approach for this. I sorted the array, then iterated through it keeping track of the
 * min value and containers. If a new value was more than 4 of the min val, assign min val and increment
 * no of containers. This approach takes O(n log(n)) time as we need to sort the array. We can optimize
 * the solution, see the below note.
 * 
 * Note: We can optimize the solution by having a visited array where we have all numbers from 0 to 10000
 * as 0 initially. If we find a number in the orders array, make visited[i] = 1. Now iterate the visited
 * array & if visited[i] != 0, increment the no of containers & mark the next 4 numbers in the visited
 * array visited[i+1]...visited[i+4] = 0. In this way, we solve it in O(n).
 */

import java.util.*;

public class Solution {

    /**
     * My Solution
     * Calculates the number of containers required based on the weighs of each order.
     * Time complexity: O(n log(n))
     * Space complexity: O(1)
     * @param orders The array denoting the weights of orders.
     * @return The number of containers.
     */
    static int toys(int[] orders) {
        Arrays.sort(orders);
        int min = orders[0];
        int containers = 1;
        for (int i = 0; i <  orders.length; i++) {
            if (orders[i] > min+4) {
                min = orders[i];
                containers++;
            }
        }
        return containers;
    }

    /**
     * Optimized Solution
     * Calculates the number of containers required based on the weighs of each order.
     * Time complexity: O(n)
     * Space complexity: O(1)
     * @param orders The array denoting the weights of orders.
     * @return The number of containers.
     */
    static int toysOptimized(int[] orders) {
        int[] visited = new int[10001];
        for (int i = 0; i < orders.length; i++) {
            visited[orders[i]] = 1;
        }
        int containers = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] != 0) {
                containers++;
                for(int j = i; j <= i+4; j++) {
                    if (j < visited.length) visited[j] = 0;
                }
            }
        }
        return containers;
    }

    public static void main(String[] args) {
        int[] orders = {1, 2, 3, 21, 7, 12, 14, 21};
        int numOfContainers = toys(orders);
        System.out.println("Number of containers required are: "+numOfContainers);
    }
}
