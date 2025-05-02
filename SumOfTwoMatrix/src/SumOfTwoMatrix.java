import java.util.Scanner;

public class SumOfTwoMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] first = fillMatrix(sc, n, m);
        int[][] second = fillMatrix(sc, n, m);

        printResults(sumOfTwoMatrix(n, m, first, second));
    }

    private static int[][] sumOfTwoMatrix(int n,
                                          int m,
                                          int[][] first,
                                          int[][] second) {
        int[][] result = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = first[i][j] + second[i][j];
            }
        }

        return result;
    }

    private static void printResults(int[][] matrix) {
        StringBuilder output = new StringBuilder();

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                output.append(anInt).append(" ");
            }
            output.append("\n");
        }

        System.out.println(output);
    }

    private static int[][] fillMatrix(Scanner sc, int n, int m) {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

}