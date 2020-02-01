/* Minimum Swaps 2 */

/**
 * Problem Statement
 * 
 * You are given an unordered array consisting of consecutive integers -E [1, 2, 3, ..., n] without any duplicates.
 * You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the array in ascending order.
 * For example, given the array arr = [7, 1, 3, 2, 4, 5, 6] we perform the following steps:
 * i   arr                     swap (indices)
 * 0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
 * 1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
 * 2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
 * 3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
 * 4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
 * 5   [1, 2, 3, 4, 5, 6, 7]
 * 
 * It took 5 swaps to sort the array.
 */

/**
 * Function Description
 * 
 * Complete the function minimumSwaps in the editor below.
 * It must return an integer representing the minimum number of swaps to sort the array.
 * 
 * minimumSwaps has the following parameter(s):
 * - arr: an unordered array of integers
 */

/**
 * Input Format
 * The first line contains an integer, n, the size of arr.
 * The second line contains n space-separated integers arr[i].
 * 
 * Constraints
 * 1 <= n <= 10^5
 * 1 <= arr[i] <= n
 * 
 * Output Format
 * Return the minimum number of swaps to sort the given array.
 */

/**
 * Sample Input
 * 4
 * 4 3 1 2
 * 
 * Sample Output
 * 3
 * 
 * Explanation
 * Given array: arr = [4, 3, 1, 2]
 * After swapping (0, 2) we get arr: [1, 3, 4, 2]
 * After swapping (1, 2) we get arr: [1, 4, 3, 2]
 * After swapping (1, 3) we get arr: [1, 2, 3, 4]
 * So, we need a minimum of 3 swaps to sort the array in ascending order.
 */

/**
 * My Code:
 * 
 * Time Complexity: O(n^2) (worst case) where n is the size of the array.
 * Space Complexity: O(n) as we create a new array of the original size for rotating.
 * 
 * Approach:
 * Initally I was thinking of all sorting algorithms & was concetrating on sorting the array.
 * Due to this, it skipped my mind, a very important hint that was given in the problem statement mentioning that
 * all elements of the array are not repeated.
 * Also I tried to derive logic looking at the sample examples. I tried to understand how they did the swaps & 
 * based on that created logic, tested it on other examples and proceeded.
 * This again was the wrong approach as logic must derived first & then tested on examples.
 * I finally came up with a solution where:
 *  Iterate through the arrau
 *  check if the index that you are at is eqaual to its value+1 (because of 0 indexing)
 *  if yes, move ahead
 *  if not, iterate through the rest of the array
 *      find either the a value in the remaining array which is equal to index+1
 *      (means if you are at a[0] = 3, find the value a[i] = 1 ) OR
 *      reach the index of the current value-1
 *      (means if you are at a[0] = 3, if you reach a[3-1] = a[2] stop)
 *      which ever condition satisfies first
 * after reaching our condition, swap the numbers, increment counter by 1 & procced
 * The above solution worked for 9 / 12 test cases, but failed for worst case scenarios
 * 
 * Editorial:
 * The editorial suggested a solutions using hashmaps & sets and keeping track of sorted numbers, creating a 
 * new sorted array & original array. I found it to be an overkill & quite frankly a bit complex
 * 
 * Best solution:
 * I found a very simple & clean solution, which got me thinking how simple the problem statement was.
 * It is given that the numbers are from 1...n, and none are repeated.
 * That means if a[i] != i+1, (a[0] != 1)
 * then just swap a[i] <--> a[a[i]-1]
 * Example:
 *  if a[0] = 3
 *  that means we know that 3 belongs to be at a[2]
 *  so swap what ever number is at a[2] with a[0]
 *  by doing so we have put 3 at its correct postion, and have a new number at a[0]
 *  now check if a[0] == 1, if yes, move ahead of the array
 *  or remain there and swap values with whatever a[value-1]
 * 
 * This solution was given by hks32 (hackerrank)
 * 
 */

public class minSwaps2 {

    /**
     * Swaps two elements in an array & returns the new array
     * @param index1 The first index whose value has to swapped
     * @param index2 The second index whose value has to swapped
     * @param arr The input array
     * @return arr The swapped array
     */
    static int[] swapValues(int index1, int index2, int[] arr) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        return arr;
    }

    /**
     * Better Solution given by hks32 (hackerrank)
     * Returns the minimum number of swaps required to sort the array
     * @param arr The unsorted array
     * @return The minimum number of swaps
     */
    static int minimumSwapsBetter(int[] arr) {
        int index = 0;
        int value = arr[index];
        int arrLen = arr.length;
        int noOfSwaps = 0;
        while (index < arrLen) {
            value = arr[index];
            if (index+1 == value) {
                index++;
                continue;
            }
            // Since the current value is not at the correct index, swap it with the value at its correct index
            arr = swapValues(index, value-1, arr);
            noOfSwaps++;
        }
        return noOfSwaps;
    }

    /**
     * My Solution:
     * Returns the minimum number of swaps required to sort the array
     * @param arr The unsorted array
     * @return The minimum number of swaps
     */
    static int minimumSwaps(int[] arr) {
        int index = 0;
        int value = arr[index];
        int arrLen = arr.length;
        int noOfSwaps = 0;
        while (index < arrLen) {
            value = arr[index];
            if (index+1 == value) {
                index++;
                continue;
            }
            int tempIndex = index;
            int tempValue = arr[index];
            /*Find either the value in the rest of the array whose value is current index+1
              OR
              Reach the index which is equal to the current value-1
              which ever is first
            */
            while(tempIndex != value-1 && tempValue != index+1) {
                tempIndex++;
                tempValue = arr[tempIndex];
            }
            System.out.println("swapping: "+arr[index]+" and "+arr[tempIndex]);
            arr = swapValues(index, tempIndex, arr);
            noOfSwaps++;
        }
        return noOfSwaps;
    }

    public static void main(String[] args) {
        int[] unsortedArr = {4, 3, 1, 2};
        int minSwaps = minimumSwapsBetter(unsortedArr);
        System.out.println("Minimum number of swaps taken to sort the array are: "+minSwaps);
    }
}