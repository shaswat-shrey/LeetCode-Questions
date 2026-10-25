package Arrays;

public class FindMissingNumber {
    public static int missing(int[] nums) {
        int len = nums.length + 1;

        for(int i=1; i<=len; i++) {
            boolean found = false;
            for (int j=0; j<len-1; j++) {
                if (nums[j] == i) {
                    found = true;
                    break;
                }
            }
             if (!found) {
                return i;
            }
        }
       return -1;
    }
}
