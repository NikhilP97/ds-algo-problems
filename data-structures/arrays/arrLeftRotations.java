/* Arrays: Left Rotation */

/**
 * Problem statement
 * 
 * A left rotation operation on an array shifts each of the array's elements 1 unit to the left.
 * For example, if 2 left rotations are performed on array [1, 2, 3, 4, 5], then the array would become [3, 4, 5, 1, 2].
 * Given an array a of n integers and a number, d, perform d left rotations on the array.
 * Return the updated array to be printed as a single line of space-separated integers.
 */

/**
 * Function Description
 * 
 * Complete the function rotLeft in the editor below. It should return the resulting array of integers.
 * rotLeft has the following parameter(s):
 *  An array of integers a.
 *  An integer d, the number of rotations.
 */

/**
 * Input Format
 * 
 * The first line contains two space-separated integers n and d, the size of a and the number of left rotations you must perform.
 * The second line contains n space-separated integers a[i].
 * 
 * Constraints
 * 
 * 1 <= n <= 10^5
 * 1 <= d <= n
 * 1 <= a[i] <= 10^6
 * 
 * Output Format
 * 
 * Print a single line of n space-separated integers denoting the final state of the array after performing d left rotations.
 * 
 */

/**
 * Sample Input
 * 5 4
 * 1 2 3 4 5
 * 
 * Sample Output
 * 5 1 2 3 4
 */


/**
 * My Code:
 * 
 * Time Complexity: O(n) where n is the size of the array.
 * Space Complexity: O(n) as we create a new array of the original size for rotating.
 * 
 * Method:
 * First check if the number of rotations is the same as the array size
 * If it is that means we will get the same array, so return the original array itself
 * If not of the same size, create a new array of the original array size
 * Now the number of rotations is actually the offset of the new rotated array
 * So the 0th element is equal to the dth element of the of  og array.
 * Continue assigning the same till the offset is equal to the array size.
 * Once its equal to the array size, make the offset 0 & continue assigning it.
 * Once we have covered all the elements, return the rotated array.
 * 
 */


public class arrLeftRotations {

    /**
     * Returns an array that is rotated left d times.
     * @param ogArray The original array to be rotated.
     * @param noOfRotations The number of left rotations to be performed on the array.
     * @return rotatedArray The new rotated array.
     */
    static int[] rotLeft(int[] ogArray, int noOfRotations) {
        int arrLen = ogArray.length;
        if (noOfRotations ==arrLen) {
            return ogArray;
        }
        int[] rotatedArray = new int[arrLen];
        int ogIndex = noOfRotations;
        for (int rotIndex=0; rotIndex < arrLen; rotIndex++) {
            rotatedArray[rotIndex] = ogArray[ogIndex];
            ogIndex++;
            if (ogIndex == arrLen) {
                ogIndex = 0;
            }
        }
        return rotatedArray;

    }

    public static void main(String[] args) {
        int[] inputArray = {1, 2, 3, 4, 5};
        int rotateLeftBy = 4;
        int[] rotatedArray = rotLeft(inputArray, rotateLeftBy);
        System.out.println("The rotated array is: ");
        for (int i = 0; i < rotatedArray.length; i++) {
            System.out.print(rotatedArray[i]+" ");
        }
        System.out.println();
    }
}
