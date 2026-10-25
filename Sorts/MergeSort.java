package Sorts;
import java.util.ArrayList;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 6, 5, 9, 7};

        mergeSort(arr, 0, arr.length-1); 

        for (int num: arr) {
            System.out.print(num+" ");
        }
    }
    public static void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low+high)/2;

        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);

        merge(nums, low, mid, high);
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        ArrayList<Integer> arr = new ArrayList<>();
        int left = low;
        int right = mid+1;

        while(left<=mid && right<=high) {
            if (nums[left] < nums[right]) {
                arr.add(nums[left++]);
            } else {
                arr.add(nums[right++]);
            }
        }
        while(left<=mid) {
            arr.add(nums[left++]);
        }
        while(right<=high) {
            arr.add(nums[right++]);
        }
        for(int i=low; i<=high; i++) {
            nums[i] = arr.get(i-low);
        }
    }
}
