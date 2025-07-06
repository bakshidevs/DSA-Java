public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 8, 9, 7, 5, 4, 2};
        System.out.println(peakIndexInMountainArray(arr));
    }
    static int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low)/2;
            if (arr[mid] > arr[mid+1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}