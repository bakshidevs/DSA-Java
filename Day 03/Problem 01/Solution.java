public class Solution {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
    }
    static int missingNumber(int[] nums) {
        int numsLen = nums.length;
        int totalSum = (numsLen * (numsLen + 1))/2;
        int sumWithMissingNum = 0;
        for (int num : nums) {
            sumWithMissingNum += num;
        }
        return totalSum - sumWithMissingNum;
    }
}