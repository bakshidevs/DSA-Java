public class SqrtX {

    public static void main(String[] args) {
        int x = 65536;
        System.out.println(sqrtX(x));
    }

    static int sqrtX(int x) {
        int low = 0;
        int high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long)mid * mid;
            if (square == x) {
                return mid;
            }
            if (square< x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }
}