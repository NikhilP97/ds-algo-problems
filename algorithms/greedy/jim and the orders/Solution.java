/**
 * Jim and the Orders
 * Java 8
 * Problem on HackerRank - https://www.hackerrank.com/challenges/jim-and-the-orders/problem
 * 
 * Time Complexity: O(n log(n)) which is required to sort the list of orders.
 * Space Complexity: O(n) where n is the list of objects of type Order.
 * 
 * Approach:
 * The problem requires us to sort the orders based on the order no & prep time. In case they are same,
 * we need to sort them based on which customer placed the order first. Since we need to check for 2 cases,
 * primitive data types won't work for our case. Hence I've used an inner class Order that stores the sum as
 * well as the customer number. I then create an Order object for each entry and then sort it using the collections
 * sort by overriding the comparable interface.
 * 
 * Note: I have changed the signature of jimOrders() from int[] to List<Order> because there was no point converting
 * the list to an integer array as it will be printed in the main() function.
 */

import java.util.*;

public class Solution {

    class Order {
        int sum;
        int customerNo;
        public Order(int sum, int customerNo) {
            this.sum = sum;
            this.customerNo = customerNo;
        }
    }

    /**
     * Sorts the orders based on the prep time & customer number to return the sequence in which 
     * customers will receive their orders.
     * @param orders The 2D array having the order number and prep time for customers.
     * @return The sequence in which the customers receive their burgers.
     */
    public List<Order> jimOrders(int[][] orders) {
        int len = orders.length;
        List<Order> orderList = new ArrayList<Order>();
        for (int i = 0; i < len; i++) {
            int sum = orders[i][0] + orders[i][1];
            int customerNo = i+1;
            Order order = new Order(sum, customerNo);
            orderList.add(order);
        }
        Collections.sort(orderList, (Order order1, Order order2) -> {
            if (order1.sum > order2.sum) return 1;
            else if (order1.sum < order2.sum) return -1;
            else {
                if (order1.customerNo > order2.customerNo) return 1;
                else if (order1.customerNo < order2.customerNo) return -1;
                else return 0;
            }
        });
        return orderList;
    }

    public static void main(String[] args) {
        int[][] orders = new int[][] {
            new int[] { 8, 1},
            new int[] { 4, 2},
            new int[] { 5, 6},
            new int[] { 3, 1},
            new int[] { 4, 3}
        };

        Solution solution = new Solution();
        List<Order> result = solution.jimOrders(orders);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(String.valueOf(result.get(i).customerNo));
            if (i != result.size() - 1) System.out.print(" ");
            else System.out.print("\n");
        }
    }
}
