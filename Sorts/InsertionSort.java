package Sorts;
public class InsertionSort {
    public static void insertionSort(int[] nums) {
        int len = nums.length;
        for (int i=1; i<len; i++) {
            int key = nums[i];
            int j = i-1;

            while (j>=0 & nums[j]>key) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 7, 5, 8, 6};

        insertionSort(arr);
        for(int num: arr) {
            System.out.print(num + " ");
        }
    }
}