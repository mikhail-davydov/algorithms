import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        System.out.println(solution(n));
    }

    private static int solution(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }

}