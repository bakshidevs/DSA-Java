public class NextGreatesLetter {

    public static void main(String[] args) {
        char[] letters = { 'c', 'f', 'j' };
        char target = 'j';
        System.out.println(nextGreatestLetter(letters, target));
    }

    static char nextGreatestLetter(char[] letters, char target) {
        int lowerBound = 0;
        int upperBound = letters.length - 1;
        if (target < letters[lowerBound] || target >= letters[upperBound]) {
            return letters[lowerBound];
        }
        while (lowerBound <= upperBound) {
            int mid = (upperBound + lowerBound) / 2;
            if (letters[mid] <= target) {
                lowerBound = mid + 1;
            } else if (letters[mid] > target) {
                upperBound = mid - 1;
            }
        }

        return letters[lowerBound];
    }
}