package org.bugkit.algorithm;

/**
 * @author bennetty74
 * @since 2021.10.23
 */
public class BinarySearch {

    public int searchByLoop(int[] arr, int target) {
        return searchByLoop(arr, 0, arr.length - 1, target);
    }

    private int searchByLoop(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int searchByRecursion(int[] arr, int target) {
        return searchByRecursion(arr, 0, arr.length - 1, target);
    }


    private int searchByRecursion(int[] arr, int low, int high, int target) {
        int mid = (low + high) / 2;
        if (target == arr[mid]) {
            return mid;
        }
        if (low > high) {
            return -1;
        }
        if (target < arr[mid]) {
            return searchByRecursion(arr, low, mid - 1, target);
        }
        return searchByRecursion(arr, mid + 1, high, target);
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("searchByLoop 5 in [1,2,3,4,5,6,7,8,9], result is: " + binarySearch.searchByLoop(arr1, 5));
        System.out.println("searchByRecursion 5 in [1,2,3,4,5,6,7,8,9], result is: " + binarySearch.searchByRecursion(arr1, 5));

        System.out.println("searchByLoop 10 in [1,2,3,4,5,6,7,8,9,10], result is: " + binarySearch.searchByLoop(arr2, 10));
        System.out.println("searchByRecursion 10 in [1,2,3,4,5,6,7,8,9,10], result is: " + binarySearch.searchByRecursion(arr2, 10));

        System.out.println("searchByLoop 1 in [1,2,3,4,5,6,7,8,9,10], result is: " + binarySearch.searchByLoop(arr2, 1));
        System.out.println("searchByRecursion 1 in [1,2,3,4,5,6,7,8,9,10], result is: " + binarySearch.searchByRecursion(arr2, 1));

        System.out.println("searchByLoop 20 in [1,2,3,4,5,6,7,8,9,10], result is: " + binarySearch.searchByLoop(arr2, 20));
        System.out.println("searchByRecursion 20 in [1,2,3,4,5,6,7,8,9,10], result is: " + binarySearch.searchByRecursion(arr2, 20));

    }


}
