import java.util.Scanner;

public class CombinationsRepetitions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        CombinationsRepetitions combinations = new CombinationsRepetitions();
        System.out.println(combinations.decision(n, k));
    }

    private int decision(int n, int k) {
        return factorial(k + n - 1) / (factorial(k) * factorial(n - 1));
    }

    private int factorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}