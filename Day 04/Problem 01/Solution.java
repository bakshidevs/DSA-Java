public class Solution {

    public static void main(String[] args) {
        int n = 10, m =3;
        System.out.println(differenceOfSums(n, m));
    }
    static int differenceOfSums(int n, int m) {
        int sumOfU = (n * (n + 1))/2;
        int numOfM = n/m;
        int sumOfM = ((numOfM * (numOfM + 1))/2 * m);
        return sumOfU - 2*sumOfM;
    }
}