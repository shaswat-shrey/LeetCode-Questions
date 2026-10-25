package Sorts;
public class BubbleSort {
    public static void bubbleSort(int[] nums) {
        int len = nums.length;
        for(int i=0; i<len-1; i++) {
            for (int j=0; j<len-i-1; j++) {
                if (nums[j] > nums[j+1]) {

                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {11, 34, 21, 35, 56, 99, 53};

        bubbleSort(arr);

        for(int num: arr) {
            System.out.print(num + " ");
        }
    }
}
