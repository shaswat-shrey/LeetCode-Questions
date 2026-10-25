package Search;
import java.util.*;
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 6, 9, 0};
        Arrays.sort(nums);
        int indx = binarySearch(nums, 9, 0, nums.length-1);
        System.out.println("idx is " + indx);
    }
    public static int binarySearch(int[] nums, int k, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (nums[mid]>k) {
            return binarySearch(nums, k, low, mid-1);
        }
        if (nums[mid]<k) {
            return binarySearch(nums, k, mid+1, high);
        }
        return mid;
    }
}
