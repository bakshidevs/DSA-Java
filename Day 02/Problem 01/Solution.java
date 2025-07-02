public class Solution {
    public static void main(String[] args) {
        int[] digits = { 9, 9, 9, 4, 9, 9 };
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println();
        int[] res = plusOne(digits);
        for (int digit : res) {
            System.out.print(digit + " ");
        }
        System.out.println();
    }

    static int[] plusOne(int[] digits) {
        int arrLen = digits.length;
        if (digits[arrLen - 1] < 9) {
            digits[arrLen - 1] = digits[arrLen - 1] + 1;
            return digits;
        }
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        if (sum == arrLen * 9) {
            // creating a new array when all the digits are 9s
            int[] newArr = new int[arrLen + 1];
            // filling them with 0
            for (int i = 0; i < newArr.length; i++) {
                newArr[i] = 0;
            }
            // updating the most significant bit
            newArr[0] = 1;
            // returning the answer
            return newArr;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            // this condition breaks the loop if flow of in the array is not continuous
            if (digits[i] != 9) {
                digits[i]++;
                break;
            }
            // place a 0 in the place of 9 (it has to be continuous flow of 9)
            if (digits[i] == 9) {
                digits[i] = 0;
            }
        }
        return digits;
    }
}

// the final solution