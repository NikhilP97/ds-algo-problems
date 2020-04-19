/**
 * Search in Rotated Sorted Array
 * Java 8
 * Problem on LeetCode - https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3304/
 * This problem was solved as part of the 30 day challenge on April 2020.
 * 
 * Time Complexity: O(log(n)) where n is the size of the array.
 * Space Complexity: O(1) as we do not need an auxillary array.
 * 
 * Approach:
 * Since we do not know where the pivot is of the rotated array, our problem boils down to finding the pivot
 * of the shifted array. Once we know the pivot, we only need to apply binary search to both sub arrays. The
 * method used to find the pivot is that we search for an element whose next element is smaller or previous
 * element is bigger. To decide which half to dispose, we check the lowest value of the current array. If the
 * arr[low] is less than arr[mid] that means the left part is as we expect it to be and we need to search in
 * the right half. Once we get the pivot, binary search on the sub array where the value could exist.
 */

class Solution {

    private int findPivot(int[] nums, int start, int end) {
        if (start > end) return -1;
        if (start == end) return end;
        int mid = start + (end-start) / 2;
        if (mid < end && nums[mid] > nums[mid+1]) return mid;
        if (mid > start && nums[mid] < nums[mid-1]) return mid-1;
        if (nums[start] > nums[mid]) return findPivot(nums, start, mid-1);
        return findPivot(nums, mid+1, end);
    }
    
    private int binarySearch(int[] arr, int low, int high, int target) {
        if (low > high) return -1;
        if (target < arr[low] || target > arr[high]) return -1;
        int mid = low + (high-low) / 2;
        if (arr[mid] == target) return mid;
        if (target > arr[mid]) return binarySearch(arr, mid+1, high, target);
        return binarySearch(arr, low, mid-1, target); 
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        int pivot = findPivot(nums, 0, n-1);
        if (target >= nums[0] && target <= nums[pivot]) {
            return binarySearch(nums, 0, pivot, target);
        }
        if (pivot+1 <= n-1 && target >= nums[pivot+1] && target <= nums[n-1]) {
            return binarySearch(nums, pivot+1, n-1, target);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        Solution solution = new Solution();
        int index = solution.search(arr, 4);
        System.out.println("The target has index: "+index);
    }
}