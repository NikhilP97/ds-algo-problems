/* Sock Merchant Problem */

/**
 * Problem Statement
 * 
 * John works at a clothing store. He has a large pile of socks that he must pair by color for sale.
 * Given an array of integers representing the color of each sock, determine how many pairs of socks
 * with matching colors there are.
 * 
 * For example, there are n = 7 socks with colors ar=[1,2,1,2,1,3,2].
 * There is one pair of color 1 and one of color 2. There are three odd socks left, one of each color.
 * There are three odd socks left, one of each color. The number of pairs is 2.
 */

/**
 * Function Description
 * 
 * Complete the sockMerchant function in the editor below.
 * It must return an integer representing the number of matching pairs of socks that are available.
 * 
 * sockMerchant has the following parameter(s):
 * 
 * n: the number of socks in the pile
 * ar: the colors of each sock
 */

/**
 * Input Format
 * 
 * The first line contains an integer n, the number of socks represented in ar.
 * The second line contains n space-separated integers describing the colors ar[i] of the socks in the
 * pile.
 */

/**
 * Constraints
 * 
 * 1 <= n <= 100
 * 1 <= ar[i] <= 100 where 0 <= i <= n
 */

/**
 * Output Format
 * 
 * Return the total number of matching pairs of socks that John can sell.
 */

/**
 * Sample Input
 * 
 * 9
 * 10 20 20 10 10 30 50 10 20
 */

/**
 * Sample Output
 * 
 * 3
 */

/**
 * Explanation
 * 
 * 10 <----> 10
 * 10 <----> 10
 * 20 <----> 20
 * 30
 * 50
 * 20
 */


/**
 * 
 * My Code:
 * 
 * Time Complexity: O(n) where n is the number of socks.
 * Space Complexity: O(m) where m is the number of unique colored socks.
 * 
 */


import java.util.*;

public class sockMerchant {

    /**
     * Returns the number of pairs of socks that are given.
     * @param noOfSocks The count of total number of socks.
     * @param arrOfSocks The array of integers representing the color of each sock.
     * @return noOfPairs The total number of socks pairs.
     */
    static int getNoOfSockPairs(int noOfSocks, int[] arrOfSocks) {
        HashMap<Integer, Integer> pairMap = new HashMap<>();
        int noOfPairs = 0;
        for (int i = 0; i < noOfSocks; i++) {
            if (pairMap.containsKey(arrOfSocks[i])) {
                int currentNoOfSocks = pairMap.get(arrOfSocks[i]);
                currentNoOfSocks += 1;
                if (currentNoOfSocks % 2 == 0) {
                    noOfPairs += 1;
                }
                pairMap.put(arrOfSocks[i], currentNoOfSocks);
            } else {
                pairMap.put(arrOfSocks[i], 1);
            }
        }
        return noOfPairs;
    }
    public static void main(String[] args) {
        int[] socks = {10,20, 20, 10, 10, 30, 50, 10, 20};
        int totalSocks = socks.length;

        int noOfSockPairs = getNoOfSockPairs(totalSocks, socks);
        System.out.println("No of Pairs are: "+noOfSockPairs);
    }
}


/**
 * I found a better implementation in the discussion section. Here the author lukes712 (HackerRank)
 * has used HashSet instead of HashMap as for this problem we don't really need to keep a track of
 * individual socks and their pairs.
 * 
 * Code:
 * 
 * Set<Integer> colors = new HashSet<>();
    int pairs = 0;

    for (int i = 0; i < n; i++) {
        if (!colors.contains(c[i])) {
            colors.add(c[i]);
        } else {
            pairs++;
            colors.remove(c[i]);
        }
    }

    System.out.println(pairs);
 */