/* Linked Lists: Detect a Cycle */

/**
 * Problem Statement
 * 
 * A linked list is said to contain a cycle if any node is visited more than once while traversing the list.
 * For example, in the following graph there is a cycle formed when node 5 points back to node 3.
 * 1 --> 2 --> 3 --> 4 --> 5 --> 3
 */

/**
 * Function Description
 * 
 * Complete the function has_cycle in the editor below. It must return a boolean true if the graph contains a cycle, or false.
 * has_cycle has the following parameter(s):
 * head: a pointer to a Node object that points to the head of a linked list.
 * Note: If the list is empty, head will be null.
 */

/**
 * Input Format
 * There is no input. A random linked list is generated at runtime and passed to your function.
 * 
 * Constraints
 * 0 <= list size <= 100
 * 
 * Output Format
 * If the list contains a cycle, your function must return true.
 * If the list does not contain a cycle, it must return false.
 * The binary integer corresponding to the boolean value returned by your function is printed to stdout by our hidden code checker.
 */


/**
 * My Code:
 * 
 * Time Complexity: O(n) where n is the size of the linked list.
 * Space Complexity: O(1) as it does not depend on the linked list size.
 * 
 * Approach:
 * 
 * I've already solved and seen this problem before. My initial solution was to use a hashset & store the nodes
 * that were visited. This solved the problem in required time but took O(n) space as we had to maintain the hashset.
 * I then read about Floyd’s Cycle-Finding Algorithm
 * Here we use two pointers, a slow pointer & fast pointer.
 * The slow pointer always increments by 1
 * The fast pointer increments by 2 from its current position
 * We can notice that distance between them (from slow to fast) increase by one after every iteration.
 * When distance becomes n, they meet because they are moving in a cycle of length n.
 * This solution doesn't require addition space, hence we can get our space down to O(1).
 * Link to article - https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
 * Floyd's algorithm - https://www.geeksforgeeks.org/how-does-floyds-slow-and-fast-pointers-approach-work/
 */

/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

public class detectCycleLL {

    public class Node {
        int data;
        Node next;
    }

    public boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }
        Node slowPointer = head;
        Node fastPointer = head;
        while (slowPointer != null && fastPointer!= null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (fastPointer == slowPointer) {
                return true;
            }
        }
        return false;
    }
}