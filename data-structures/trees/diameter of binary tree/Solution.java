/**
 * Diameter of Binary Tree
 * Java 8
 * Problem on LeetCode - https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3293/
 * This problem is part of the 30 day leet code challenge of April 2020.
 * 
 * Time Complexity: O(n) since we traverse all nodes in the root.
 * Space Complexity: O(n) as we recursively traverse to each node, the call stack increases to the deepest node.
 * 
 * Approach:
 * To calculate the diameter we need to find the node, whose left sub root length + right sub root length. So
 * we traverse to the leaf nodes first. So the left and right depth will be 0. Now we return, the bigger value
 * between the left and right depth plus one. So if leftDepth = 0, rightDepth = 0, we return 0+1 = 1. So the
 * parent node will get left depth as 1. Also to find the max diameter at every stage we calculate the
 * if leftDepth + rightDepth > max. If it is we assign it to max. So in conclusion we always return the greater
 * depth between left and right and add 1 to it because we are moving a level closer. And once we get the depth
 * in the parent node, we add left + right depth and check if it is greater than max.
 */

class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int max = 0;
    
    private int diameter(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = diameter(root.left);
        int rightDepth = diameter(root.right);
        if (leftDepth + rightDepth > max) max = leftDepth + rightDepth;
        return leftDepth > rightDepth ? leftDepth+1 : rightDepth+1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        /*
                    1
                  /   \
                 2      3
               /  \
              4     5
        */
        TreeNode root = sol.new TreeNode(1);
        root.left = sol.new TreeNode(2); 
        root.right = sol.new TreeNode(3); 
        root.left.left = sol.new TreeNode(4); 
        root.left.right = sol.new TreeNode(5);
        int diameter = sol.diameterOfBinaryTree(root);
        System.out.println("The diameter of the tree is: "+diameter);
    }
}