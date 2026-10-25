package Arrays;
public class SecondLargestNumber {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 56, 2};

        int number = secondLargestNumber(arr);
        System.out.println("num:"+ number);
    }

    public static int secondLargestNumber(int[] nums) {
        int count = 0;
        int number = 0;
        int temp;
        for(int num: nums) {
            if (num > count) {
                temp = count;
                count  = num;
                number = temp;

            }
        }
        return number;
       
    }
}
