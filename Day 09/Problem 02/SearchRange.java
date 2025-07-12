public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {  };
        int target = 26;
        // searchRange(nums, target);
        int[] res = searchRange(nums, target);
        for (int num : res) {
            System.out.println(num);
        }
    }

    static int[] searchRange(int[] nums, int target) {
        if (nums.length < 1) {
            return new int[] { -1, -1 };
        }
        int lowerBound = 0;
        int upperBound = nums.length - 1;
        int[] range = new int[2];

        if (target > nums[upperBound] || target < nums[lowerBound]) {
            return new int[] { -1, -1 };
        }

        
        // finding the lowerBound or starting index of the target
        while (lowerBound <= upperBound) {
            int mid = (upperBound + lowerBound) / 2;
            if (nums[mid] >= target) {
                upperBound = mid - 1;
            } else if (nums[mid] < target) {
                lowerBound = mid + 1;
            }
        }
        
        if (lowerBound >= nums.length || nums[lowerBound] != target) {
            return new int[] { -1, -1 };
        }
        range[0] = lowerBound;
        lowerBound = 0;
        upperBound = nums.length - 1;
        // finding the upperBound or starting index of the target
        while (lowerBound <= upperBound) {
            int mid = (upperBound + lowerBound) / 2;
            if (nums[mid] <= target) {
                lowerBound = mid + 1;
            } else if (nums[mid] > target) {
                upperBound = mid - 1;
            }
        }
        range[1] = upperBound;
        return range;
    }
}