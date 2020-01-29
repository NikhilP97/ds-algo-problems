/* Jumping on the Clouds */

/**
 * Problem Statement
 * 
 * Emma is playing a new mobile game that starts with consecutively numbered clouds.
 * Some of the clouds are thunderheads and others are cumulus. She can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus 1 or 2.
 * She must avoid the thunderheads. Determine the minimum number of jumps it will take Emma to jump from her starting postion to the last cloud.
 * It is always possible to win the game.

 * For each game, Emma will get an array of clouds numbered 0 if they are safe or 1 if they must be avoided.
 * For example, c = [0,1,0,0,0,1,0] indexed from 0 to 6. The number on each cloud is its index in the list so she must avoid the clouds at indexes 1 and 5.
 * She could follow the following two paths: 0-->2-->4-->6 or 0-->2-->3-->4-->6.
 * The first path takes 3 jumps while the second takes 4.
 */

/**
 * Function Description
 * 
 * Complete the jumpingOnClouds function in the editor below. It should return the minimum number of jumps required, as an integer.
 * jumpingOnClouds has the following parameter(s):
 * - c: an array of binary integers
 */

/**
 * Input Format
 * 
 * he first line contains an integer n, the total number of clouds.
 * The second line contains n space-separated binary integers describing clouds c[i] where 0<=i<=n.
 * 
 * Constraints
 * 
 * 2<=n<=100
 * c[i] <--> {0,1}
 * c[0] = c[n-1] = 0
 * 
 * Output Format
 * 
 * Print the minimum number of jumps needed to win the game.
 */

/**
 * Sample Input Output
 * 
 * Input1:
 * 7
 * 0 0 1 0 0 1 0
 * 
 * Output1:
 * 4
 * 
 * Input2:
 * 6
 * 0 0 0 0 1 0
 * 
 * Output2:
 * 3
 */


/**
 * My Code
 * Time Complexity: O(n) where n is the total number of clouds
 * Space Complexity: O(1) as it does not depend on the number of clouds
 * 
 * P.S:
 * 
 * The below code was my first attempt at solving the problem. I did not keep in mind the constraints due to
 * which my code isn't very clean and has extra logic which is not required for this problem. I tried to cover 
 * all edge cases only to realize later that they wouldn't exist. I've written 2 functions.
 * 1. jumpingOnCloudsOriginal ( original solution )
 * 2. jumpingOnCloudsRefactored ( revised one )
 */

public class jumpingOnClouds {

    static int jumpingOnCloudsRefactored(int[] clouds) {
        int noOfClouds = clouds.length;
        int index = 0;
        int noOfJumps = 0;
        while (index < noOfClouds - 1) {
            if (index+2 < noOfClouds && clouds[index+2] != 1) {
                index += 2;
            } else {
                index += 1;
            }
            noOfJumps += 1;
        }
        return noOfJumps;
    }
    
    static int jumpingOnCloudsOriginal(int[] clouds) {
        int noOfClouds = clouds.length;
        int index = 0;
        int noOfJumps = 0;
        while (index < noOfClouds) {
            /**
             * If current cloud is 1, then:
             * check if next cloud is 0, if it is increase number of jumps by 1 & continue
             * else, move on to next cloud
             */
            if (clouds[index] == 1 ) {
                if (clouds[index+1] == 0) {
                    noOfJumps += 1;
                }
                index += 1;
                continue;
            }
            /**
             * Since the code has reached here, means the cloud is 0
             * check if we can jump over 2 clouds
             * if yes, check if both clouds are 0 0
             * if yes, then make 1 jump & move ahead by 2 clouds
             */
            if (index+2 < noOfClouds) {
                if (clouds[index+1] == 0 && clouds[index+1] == 0) {
                    noOfJumps += 1;
                    index += 2;
                    continue;
                }
            }
            /**
             * If here that means we cannot jump 2 clouds or the next 2 clouds are not 0 0
             * check if we can jump 1 cloud next
             * if yes, increase the number of jumps by 1
             * else move ahead
             */
            if (index+1 < noOfClouds) {
                if (clouds[index+1] == 0) {
                    noOfJumps += 1;
                }
            }
            index += 1;
        }
        return noOfJumps;
    }

    public static void main(String[] args) {
        int[] clouds = {0, 0, 1, 0, 0, 1, 0};
        boolean runRevisedCode = true;
        int noOfJumps;
        if (runRevisedCode) {
            noOfJumps = jumpingOnCloudsRefactored(clouds);
        } else {
            noOfJumps = jumpingOnCloudsOriginal(clouds);
        }
        System.out.println("The total number of jumps are: "+noOfJumps);
    }
}

