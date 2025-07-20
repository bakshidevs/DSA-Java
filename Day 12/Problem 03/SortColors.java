public class SortColors {
    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    static void sortColors(int[] nums) {
        // Counting the number of zeros, ones and twos(nums.length - noOfZeros -
        // noOfOnes).
        int noOfZeros = 0;
        int noOfOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                noOfZeros++;
            if (nums[i] == 1)
                noOfOnes++;
        }

        // Inserting based on the count.
        for (int i = 0; i < nums.length; i++) {
            // Array is 0 indexed so we start from zero to noOfZeros - 1 index.
            if (i < noOfZeros) {
                nums[i] = 0;
            }
            // Here we start from noOfZeros to (noOfZeros + noOfOnes) - 1 index.
            if (i >= noOfZeros && i < noOfZeros + noOfOnes) {
                nums[i] = 1;
            }
            // Also, here we start from (noOfZeros + noOfOnes) to nums.length - 1 index.
            if (i >= noOfZeros + noOfOnes && i < nums.length) {
                nums[i] = 2;
            }
        }
    }
}
