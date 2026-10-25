package Arrays;
import java.util.Arrays;

public class SlidingWindow {
    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);

        int l = 0;
        long sum = 0;
        int maxFreq = 0;

        for (int r=0; r<nums.length; r++) {
            sum += nums[r];

            while((long)(r-l+1) * nums[r] - sum > k) {
                sum = sum - nums[l];
                l++;
            }

            maxFreq = Math.max(maxFreq, r-l+1);
        }

        return maxFreq;
    }
}

/*
basic formula is  { (windowSize * target) - WindowSum } 
where this formula need to be less then the value k and if it increases k then left 
pointer will move right 
*/ 
