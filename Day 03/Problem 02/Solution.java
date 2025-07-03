public class Solution {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 13;
        System.out.println(binarySearch(nums, target));
    }

    static int binarySearch(int[] nums, int target) {
        int lowerBound = 0;
        int upperBound = nums.length - 1;
        while (lowerBound <= upperBound) {
            int mid = (upperBound + lowerBound) / 2;
            if (target > nums[mid]) {
                lowerBound = mid + 1;
            } else if (target < nums[mid]) {
                upperBound = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
