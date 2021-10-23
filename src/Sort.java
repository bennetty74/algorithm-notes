import java.util.Arrays;

/**
 * Sort array with asc order
 *
 * @author bennetty74
 * @since 2021.10.23
 */
public class Sort {

    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i], minIdx = i;
            //select min element in right array
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIdx = j;
                }
            }
            // swap
            swap(arr, i, minIdx);
        }
    }

    public void quickSort(int[] arr) {
        quickSortInternal(arr, 0, arr.length - 1);
    }

    private void quickSortInternal(int[] arr, int low, int high) {
        int left = low, right = high;
        while (left < right) {
            while (arr[left] < arr[low]) {
                left++;
            }
            while (arr[right] > arr[low]) {
                right--;
            }
            swap(arr, left, right);
        }
        // then the low element is lower than the element in pivotIdx
        // the high element is higher than the element in pivotIdx
        // repeat the above steps in left arr and right arr if low < high
        if (low < high) {
            quickSortInternal(arr, low, low - 1);
            quickSortInternal(arr, low + 1, high);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] arr1;
        int[] arr2;

        arr1 = new int[]{1};
        arr2 = new int[]{2, 4, 1, 3, 9, 8, 7, 5, 6};
        sort.quickSort(arr1);
        sort.quickSort(arr2);
        System.out.println("Sort quickSort [1] result is: " + Arrays.toString(arr1));
        System.out.println("Sort quickSort [2,4,1,3,9,8,7,5,6] result is: " + Arrays.toString(arr2));

        arr1 = new int[]{1};
        arr2 = new int[]{2, 4, 1, 3, 9, 8, 7, 5, 6};
        sort.selectSort(arr1);
        sort.selectSort(arr2);
        System.out.println("Sort selectSort [1] result is: " + Arrays.toString(arr1));
        System.out.println("Sort selectSort [2,4,1,3,9,8,7,5,6] result is: " + Arrays.toString(arr2));

    }
}
