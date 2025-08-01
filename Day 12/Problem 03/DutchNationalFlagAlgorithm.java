public class DutchNationalFlagAlgorithm {
        public static void main(String[] args) {
                int[] nums = { 2, 0, 2, 1, 1, 0 };
                dutchNationalFlagAlgorithm(nums);
                for (int num : nums) {
                        System.out.print(num + " ");
                }
                System.out.println();
        }

        static void dutchNationalFlagAlgorithm(int[] arr) {
                int low = 0;
                int mid = 0;
                int high = arr.length - 1;

                while (mid <= high) {
                    switch (arr[mid]) {
                        case 0 -> {
                            swap(arr, low, mid);
                            low++;
                            mid++;
                        }
                        case 1 -> mid++;
                        default -> {
                            swap(arr, mid, high);
                            high--;
                        }
                    }
                }
        }

        static void swap(int[] arr, int i, int j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
        }

}
