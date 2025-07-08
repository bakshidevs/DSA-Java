
public class FindCeiling {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 4, 4, 4, 4, 8, 10, 11, 12, 19 };
        int x = 5;
        System.out.println(findCeiling(arr, x));
    }

    static int findCeiling(int[] arr, int x) {
        int lowerBound = 0;
        int upperBound = arr.length - 1;
        int res = -1;
        if (x < arr[lowerBound]) {
            return 0;
        }
        if (x > arr[upperBound]) {
            return res;
        }
        while (lowerBound <= upperBound) {
            int mid = lowerBound + (upperBound - lowerBound) / 2;
            if (x == arr[mid]) {
                res = mid;
                upperBound = mid - 1;
            } else if (x < arr[mid]) {
                upperBound = mid - 1;
            } else {
                lowerBound = mid + 1;
            }
        }
        
        return res;
    }
}
