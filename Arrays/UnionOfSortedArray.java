package Arrays;
import java.util.*;
public class UnionOfSortedArray {
    public static void main(String args[]) {
        int[] arr1 = {1, 2, 2, 3, 4, 5, 6};
        int[] arr2 = {2, 3, 4, 4, 5, 6, 7};

        List<Integer> unionArray = unionArray(arr1, arr2);
        for (int num: unionArray) {
            System.out.print(num + " ");
        }
    }

    public static List<Integer> unionArray(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<>();
        int n = nums1.length;
        int m = nums2.length;
        int i = 0, j = 0;
        while (i<n && j<m) {
            if (nums1[i] < nums2[j]) {
                if (arr.isEmpty() || arr.get(arr.size()-1) != nums1[i]) {
                    arr.add(nums1[i]);
                }
                i++;
            }else if (nums2[j] < nums1[i]) {
                if (arr.isEmpty() || arr.get(arr.size()-1) != nums2[j]) {
                    arr.add(nums2[j]);
                }
                j++;
            }else {
                if (arr.isEmpty() || arr.get(arr.size()-1) != nums1[i]) {
                    arr.add(nums1[i]);
                }
                i++; j++;
            }
        }
        while (i < n) {
            if (arr.isEmpty() || arr.get(arr.size()-1) != nums1[i]) {
                arr.add(nums1[i]);
            }
            i++;
        }
        while (j < m) {
            if (arr.isEmpty() || arr.get(arr.size()-1) != nums2[j]) {
                arr.add(nums2[j]);
            }
            j++;
        }
        return arr;
        
    }
}

