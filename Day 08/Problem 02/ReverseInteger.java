
public class ReverseInteger {
    public static void main(String[] args) {
        int num = -2147483648;
        System.out.println(reverseInteger(num));
    }

    static int reverseInteger(int x) {
        int newNum = 0;
        while (x != 0) {
            int currentDigit = x % 10;
            x = x / 10;
            if (newNum > Integer.MAX_VALUE / 10 || (newNum == Integer.MAX_VALUE / 10 && currentDigit > 7)) {
                return 0;
            }
            if (newNum < Integer.MIN_VALUE / 10 || (newNum == Integer.MIN_VALUE / 10 && currentDigit < -8)) {
                return 0;
            }
            newNum = newNum * 10 + currentDigit;
        }
        return newNum;
    }
}
