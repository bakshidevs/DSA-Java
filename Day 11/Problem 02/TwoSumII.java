

public class TwoSumII {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] range = twoSum(numbers, target);
        System.out.println(range[0] + " " + range[1]);
    }
    static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int[] range = {0, 0};
        while(start < end) {
            int sum = numbers[start] + numbers[end];
            if(sum == target) {
                range[0] = start + 1;
                range[1] = end + 1;
                break;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return range;
    }
}
