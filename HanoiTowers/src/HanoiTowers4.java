import java.util.Scanner;

// todo
class HanoiTowers4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n < 3 || n > 10) {
            throw new IllegalArgumentException("n must be between 3 and 10");
        }

        int towers = 4;

        System.out.println(4 * n - 7);
    }
}
