/**
 * Cavity Map
 * Java 8
 * Problem on HackerRank - https://www.hackerrank.com/challenges/cavity-map/problem
 * 
 * Time Complexity: O(n^2) since we need to iterate through the 2D array.
 * Space Complexity: O(n^2) to store the 2D array.
 * 
 * Approach:
 * Iterate through the 2D array, for every element, check if all its neighbors have a smaller
 * depth. If true, it is a cavity & make it as 'X'. If not, continue iterating the array.
 */


public class Solution {

    /**
     * Marks an X for all elements in the String array which qualify as a cavity.
     * @param grid The input String array.
     * @return The new string array with all cavities marked as 'X'.
     */
    static String[] cavityMap(String[] grid) {
        String[] result = new String[grid.length];
        result[0] = grid[0];
        for (int i = 1; i < grid.length-1; i++) {
            StringBuilder row = new StringBuilder(grid[i]);
            for(int j = 1; j < grid.length-1; j++) {
                boolean isCavity = checkIfCavity(i, j, grid);
                if (isCavity) row.setCharAt(j, 'X');
            }
            result[i] = row.toString();
        }
        result[result.length-1] = grid[grid.length-1];
        return result;
    }

    /**
     * Checks if a particular element is a cavity or not
     * @param row The row of the element.
     * @param col The column of the element.
     * @param grid The grid in which the element is present.
     * @return true if its is a cavity, false otherwise.
     */
    private static boolean checkIfCavity(int row, int col, String[] grid) {
        char upperNeighbor = grid[row-1].charAt(col);
        char bottomNeighbor = grid[row+1].charAt(col);
        char leftNeighbor = grid[row].charAt(col-1);
        char rightNeighbor = grid[row].charAt(col+1);
        char element = grid[row].charAt(col);
        if (element > upperNeighbor && element > bottomNeighbor && element > leftNeighbor && element > rightNeighbor) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] grid = {
            "1112",
            "1912",
            "1892",
            "1234"
        };
        String[] result = cavityMap(grid);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
