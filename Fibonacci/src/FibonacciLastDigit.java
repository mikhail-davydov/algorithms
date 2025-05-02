import java.util.Scanner;

public class FibonacciLastDigit {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        System.out.println(solution(n));
    }

    private static int solution(int n) {
        if (n <= 1) {
            return n;
        }

        int[] lastDigits = new int[n + 1];

        lastDigits[0] = 0;
        lastDigits[1] = 1;
        for (int i = 2; i <= n; i++) {
            lastDigits[i] = (lastDigits[i - 1] + lastDigits[i - 2]) % 10;
        }
        return lastDigits[n];
    }

}
