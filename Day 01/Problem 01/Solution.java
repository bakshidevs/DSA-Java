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
                count = count + 1;
				// int temp = nums[i];
				// for (int j = nums.length - 1; j > i; j--){
				// 	if(temp != nums[j]) {
				// 		nums[i] = nums[j];
				// 		nums[j] = temp;
				// 	}
				// }
            }
        }
		
			int[] newArr = new int[count];
			int pos = 0;
			for (int i = 0; i < nums.length; i++) {
				if (val != nums[i]) {
					newArr[pos] = nums[i];
					pos++;
				}
			}
            System.arraycopy(newArr, 0, nums, 0, newArr.length);
		
		return count;
	}
}
