public class Solution {
	public static void main(String[] args) {
		int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int result = removeElement(nums, 2);
		System.out.println(result);
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	static int removeElement(int[] nums, int val) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (val != nums[i]) {
				nums[count] = nums[i];
				count = count + 1;
			}
		}

		return count;
	}
}
