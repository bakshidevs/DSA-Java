public class SingleNonDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }

    static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int lowerBound = 0;
        int upperBound = nums.length - 1;

        while (lowerBound < upperBound) {
            int mid = lowerBound + (upperBound - lowerBound) / 2;
            if (mid % 2 == 1) {
                mid--; 
            }
            if (nums[mid] == nums[mid + 1]) {
                lowerBound = mid + 2;
            } else {
                upperBound = mid;
            }
        }
        return nums[lowerBound];
    }
}