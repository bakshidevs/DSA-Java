public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 5, 5, 7, 3, 4, 6, 4, 3, 6, 1};
        System.out.println(singleNumber(nums));
    }
    static int singleNumber(int[] nums) {
        int singleNum = 0;
        for (int num : nums) {
                singleNum = singleNum ^ num;
            }
        return singleNum;
    }
}