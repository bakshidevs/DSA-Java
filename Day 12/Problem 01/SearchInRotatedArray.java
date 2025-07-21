public class SearchInRotatedArray {

    public static void main(String[] args) {
        int[] arr = { 5, 1, 3 };
        int target = 3;
        int result = searchInRotatedArray(arr, target);
        System.out.println("Element found at index: " + result);

    }

    static int searchInRotatedArray(int[] nums, int target) {
        int lowerBound = 0;
        int upperBound = nums.length - 1;
        while (lowerBound <= upperBound) {
            int mid = lowerBound + (upperBound - lowerBound) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[lowerBound] <= nums[mid]) {
                if (target >= nums[lowerBound] && target < nums[mid]) {
                    upperBound = mid - 1;
                } else {
                    lowerBound = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[upperBound]) {
                    lowerBound = mid + 1;
                } else {
                    upperBound = mid - 1;
                }
            }
        }
        return -1;
    }
}