/**
 * Flipping bits
 * Java 8
 * Problem on HackerRank - https://www.hackerrank.com/challenges/flipping-bits/problem
 * 
 * Time Complexity: O(1) since time taken to calculate the complement does not vary by the input.
 * Space Complexity: O(1) since space taken to calculate the complement does not vary by the input.
 * 
 * Approach:
 * I used a naive approach to solve this problem. I first converted the long to binary in string format.
 * I then padded 0's to it based as it requires 32 zero's as mentioned in the problem statement. I next
 * used a string builder, iterated through each character and took the complement storing it in the 
 * string builder. I finally converted the complement in binary back to long.
 * 
 * Note:
 * 1) An optimization this problem is that we do not have to convert the number to binary. Since we know
 * we are dealing with 32 bit unsigned numbers, subtracting the original number from the maximum value will
 * give you the complement. I have written a separate function for this implementation.
 * 
 * 2) Another way to solve this problem is to use the XOR bitwise operator. We take the largest value possible
 * which is 2^32-1. Now the input number XOR with the max value will give us the complement as 1 XOR 1 = 0 &
 * 1 XOR 0 = 1. Hence we get the complement and flip the bits.
 */
public class Solution {

    /**
     * Flips the bits in binary of the 32 bit unsigned long number.
     * @param number The  number whose complement has to be calculated.
     * @return The complement of the number.
     */
    static long flippingBits(long number) {
        String binaryInput = Long.toString(number, 2);
        // by default the padding operation will be performed using spaces.
        // hence we use replace() to pad with 0
        String paddedInput = String.format("%1$32s", binaryInput).replace(' ', '0');
        StringBuilder binaryOutput = new StringBuilder("");
        for (int i = 0; i < paddedInput.length(); i++) {
            char curr = paddedInput.charAt(i);
            if (curr == '1') binaryOutput.append("0");
            else binaryOutput.append("1");
        }
        return Long.parseLong(binaryOutput.toString(), 2);
    }

    static long flippingBitsSubtractFromMaxVal(long number) {
        long maxInt = (long) Math.pow(2, 32) - 1;
        return maxInt - number;
    }

    static long flippingBitsUsingXOR(long n) {
        long maxInt = (long) Math.pow(2, 32) - 1;
        return maxInt ^ n;
    }

    public static void main(String[] args) {
        long number  = 2147483647;
        long result = flippingBits(number);
        System.out.println("The complement is : "+result);
    }
}
