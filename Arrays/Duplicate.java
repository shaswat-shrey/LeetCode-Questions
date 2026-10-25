package Arrays;
import java.util.*;
public class Duplicate {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 56, 2};
        arr = removeDuplicate(arr);
        for(int num: arr) {
            System.out.print(num + " ");
        }
    }

    public static int[] removeDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }

        int[] arr = new int[set.size()];
        int r=0;
        for (int number: set) {
            arr[r++] = number;
        }
        return arr;
    }
}
