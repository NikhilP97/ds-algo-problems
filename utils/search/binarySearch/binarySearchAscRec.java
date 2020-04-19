class binarySearchAscRec {

    /**
     * Binary Search for ascending sort using recursion.
     * @param arr
     * @param low
     * @param high
     * @param target
     * @return Returns index of the target value, -1 if not found.
     */
    private int binarySearch(int[] arr, int low, int high, int target) {
        if (low > high) return -1;
        if (target < arr[low] || target > arr[high]) return -1;
        int mid = low + (high-low) / 2;
        if (arr[mid] == target) return mid;
        if (target > arr[mid]) return binarySearch(arr, mid+1, high, target);
        return binarySearch(arr, low, mid-1, target); 
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        binarySearchAscRec binarySearchAscRec = new binarySearchAscRec();
        int target = -1;
        int index = binarySearchAscRec.binarySearch(arr, 0, arr.length-1, target);
        System.out.println("Index of target is at: "+index);
    }
}