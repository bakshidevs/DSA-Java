
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        int numRows = 7;
        List<List<Integer>> matrix = pascalsTriangle(numRows);
        System.out.println("Pascal's Triangle:");
        for (List<Integer> row : matrix) {
            System.out.println(row);
        }
    }

    static List<List<Integer>> pascalsTriangle(int numRows) {
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    matrix.get(i).add(1);
                } else {
                    matrix.get(i).add(matrix.get(i - 1).get(j - 1) + matrix.get(i - 1).get(j));
                }
            }
        }
        return matrix;
    }
}
