package Sorts;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3, 6, 8, 7, 9, 0};

        quickSort(arr, 0, arr.length-1);

        for(int num: arr) {
            System.out.print(num + " ");
        }
    }
    public static void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int partition = partition(nums, low, high);
        quickSort(nums, low, partition-1);
        quickSort(nums, partition+1, high);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low, j = high;

        while(i < j) {
            while(nums[i] <= pivot && i<=high) i++;
            while(nums[j] > pivot && j>=low) j--;
            if(i < j) swap(nums, i, j); 
        }
        swap(nums, low, j); 
        return j;
    }
}
