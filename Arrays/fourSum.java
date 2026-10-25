package Arrays;
import java.util.*;

public class fourSum {
    public List<List<Integer>> fourSumm(int[] nums, int target) {
        List<List<Integer>> array = new ArrayList<>();
        int len = nums.length;

        for (int i=0; i<len-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j=i+1; j<len-2; j++) {
                if (j > 0 && nums[j] == nums[j-1]) {
                    continue;
                }
                int left = i+1;
                int right = len-1;

                long remaining = (long) target - nums[i] - nums[j];

                while (left < right) {
                    int current = nums[i] + nums[j];

                    if (current > remaining) {
                        right--;
                    }else if (current < remaining) {
                        left++;
                    }else {
                        array.add(Arrays.asList(
                            nums[i],
                            nums[j],
                            nums[left],
                            nums[right]
                        ));
                        right--;
                        left++;

                        while (left < right && nums[left] == nums[left-1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right+1]) {
                            right++;
                        }
                    }
                }

            }
        }
        return array;
    }
}
