import java.util.HashMap;

public class HashMapProb {
    public static boolean subSequence(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> need = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(map, 0) + 1);
        }

        for (int num: nums) {

            if(map.get(num) == 0) continue; 

            if (need.getOrDefault(num, 0) > 0) {
                map.put(num, map.get(num) - 1);
                need.put(num, need.get(num - 1));
                need.put(num+1, need.getOrDefault(num+1, 0) + 1);
            }else if (map.getOrDefault(num+1, 0) > 0 && map.getOrDefault(num+2, 0) > 0) {
                map.put(num, map.get(num) - 1);
                map.put(num+1, map.get(num+1) - 1);
                map.put(num+2, map.get(num+2) - 1);
                need.put(num+3, need.getOrDefault(num + 1, 0) + 1);
            }else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 4, 5, 6};
        boolean result = subSequence(arr);

        System.out.println("Result is " + result);
    }
}
