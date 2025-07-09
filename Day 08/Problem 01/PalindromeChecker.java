public class PalindromeChecker {
    public static void main(String[] args) {
        int num = 1000000001;
        System.out.println(isPalindrome(num));
    }

    static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int storedX = x;
        int newNum = 0;
        while (x > 0) {
            newNum = newNum * 10 + x % 10;
            x = x / 10;
        }

        return storedX == newNum;
    }
}