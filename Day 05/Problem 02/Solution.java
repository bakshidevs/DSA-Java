public class Solution {
    public static void main(String[] args) {
        String[] operations = {"X++","++X","--X"};
        System.out.println(finalValueAfterOperations(operations));
    }
    static int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String str : operations) {
            if(str.equals("++X") || str.equals("X++")) x++;
            if(str.equals("--X") || str.equals("X--")) x--;
        }
        return x;
    }
}