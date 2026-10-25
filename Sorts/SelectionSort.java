package Sorts;
public class SelectionSort {
    public static void selectionSort(int[] nums) {
        int len = nums.length;
        for (int i=0; i<len-1; i++) {
            int minIndex = i;
            for (int j=i+1; j<len; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                    
                }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 42, 11, 34, 32, 49, 13};

        selectionSort(arr);

        for(int num: arr) {
            System.out.print(num + " ");
        }
    }
    
}
