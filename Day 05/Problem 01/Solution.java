public class Solution {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 3, 4, 5, 5, 6, 7, 8, 9, 9, 10 };
        int target = 9;
        System.out.println(searchInsert(nums, target));
    }

    static int searchInsert(int[] nums, int target) {
        int lowerBound = 0;
        int upperBound = nums.length - 1;

        while (lowerBound <= upperBound) {
            int mid = lowerBound + (upperBound - lowerBound) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lowerBound = mid + 1;
            } else {
                upperBound = mid - 1;
            }
        }
        return lowerBound;
    }
}