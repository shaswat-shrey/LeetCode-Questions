package Search;
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6, 7, 8, 12};
        int find = linearSearch(arr, 12);

        System.out.println("Index of the number: " + find);

    }
    public static int linearSearch(int[] nums, int num) {
        int n = nums.length;
        for (int i=0; i<n; i++) {
            if (nums[i] == num) {
                return i;
            }
        }
        return -1;
    }
}
