/* Counting Valleys Problem */

/**
 * Problem Statement
 * 
 * Gary is an avid hiker. He tracks his hikes meticulously, paying close attention to small details like topography. During his last hike he took exactly n steps. For every step he took, he noted if it was an uphill, U, or a downhill, D step. Gary's hikes start and end at sea level and each step up or down represents a  unit change in altitude. We define the following terms:
 *
 * A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
 * A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
 * Given Gary's sequence of up and down steps during his last hike, find and print the number of valleys he walked through.
 * 
 * For example, if Gary's path is s=[DDUUUUDD], he first enters a valley 2 units deep. Then he climbs out an up onto a mountain 2 units high. Finally, he returns to sea level and ends his hike.
 */

/**
 * Function Description
 * 
 * Complete the countingValleys function in the editor below. It must return an integer that denotes the number of valleys Gary traversed.

 * countingValleys has the following parameter(s):
 * 
 * n: the number of steps Gary takes
 * s: a string describing his path
 */

/**
 * Input Format
 * 
 * The first line contains an integer n, the number of steps in Gary's hike.
 * The second line contains a single string s, of n characters that describe his path.
 * 
 * Constraints
 * 
 * 2 <= n <= 10^6
 * s[i] --> {U,D}
 * 
 * Output Format
 *
 * Print a single integer that denotes the number of valleys Gary walked through during his hike.
 */

/**
 * Sample Input
 * 
 * 8
 * UDDDUDUU
 * 
 * Sample Output
 * 1
 * 
 * Explanation
 * 
 * If we represent _ as sea level, a step up as /, and a step down as \, Gary's hike can be drawn as:
 * _/\      _
      \    /
       \/\/
    He enters and leaves one valley.
 */


/**
 * My Code:
 * 
 * Time Complexity: O(n) where n is the number of steps covered.
 * Space Complexity: O(1) since it does not depend on the number of steps.
 * 
 */


public class countingValleys {

    /**
     * Resolves the current step from a charcter to a number returning the next altitude of the hiker.
     * @param stepDirection Denotes if the current step is uphill or downhill.
     * @param currentHeight The current altitude the hiker is at.
     * @return The new altitude of the hiker after taking the current step.
     */
    static int resolveHeight(char stepDirection, int currentHeight) {
        // If step is uphill, height is positive else negative
        if (stepDirection == 'U') {
            return currentHeight + 1;
        }
        return currentHeight - 1;
    }

    /**
     * Returns the number of valleys crossed.
     * @param noOfSteps The total number of steps climbed or descended.
     * @param steps The string denoting each step if it was uphill or downhill.
     * @return The total count of valleys crossed.
     */
    static int getNoOfValleysCrossed(int noOfSteps, String steps) {
        int noOfValleys = 0;
        int currentHeight = 0;
        int nextHeight;
        boolean valleyStarted = false;
        boolean valleyEnded = false;
        for (int i = 0; i < noOfSteps; i++) {
            nextHeight = resolveHeight(steps.charAt(i), currentHeight);
            if (currentHeight == 0 && nextHeight == -1) {
                valleyStarted = true;
            }
            if (currentHeight == -1 && nextHeight == 0) {
                valleyEnded = true;
            }
            if (valleyStarted && valleyEnded) {
                noOfValleys += 1;
                valleyStarted = false;
                valleyEnded = false;
            }
            currentHeight = nextHeight;
        }
        return noOfValleys;
    }
    public static void main(String[] args) {
        String path = "UDDDUDUU";
        int noOfSteps = path.length();
        int noOfValleys = getNoOfValleysCrossed(noOfSteps, path);
        System.out.println("No of Valleys covered: "+noOfValleys);
    }
}