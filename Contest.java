import java.util.*;;

public class Contest {
    public static int longestSubarray(int[] nums, int k) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int num: nums) {
            ArrayList<Integer> arr = primeSet(num);
            if(!map.containsKey(num)) {
                map.put(num, arr);
            }
        }
        HashMap<Integer, Integer> primeFreq = new HashMap<>();
        int left = 0;
        int ans = 0;

        for (int right = 0; right<nums.length; right++) {
            for(int prime: map.get(nums[right])) {
                primeFreq.put(prime, primeFreq.getOrDefault(prime, 0) + 1);
            }

            while(primeFreq.size() > k) {
                for (int prime: map.get(nums[left])) {
                    int freq = primeFreq.get(prime);
                    if(freq == 1) {
                        primeFreq.remove(prime);
                    }else {
                        primeFreq.put(prime, primeFreq.get(prime)-1);
                    }
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
    public static ArrayList<Integer> primeSet(int num) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i=2; i*i <= num; i++) {
            if (num % i == 0) {
                arr.add(i);
            } 
            while(num % i == 0) {
                num /= i;
            }
        }
        if (num > 1) arr.add(num);
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {7, 6, 10, 12, 11};
        int k = 3;
        int result = longestSubarray(arr, k);

        System.out.println("Result is " + result);
    }
}
