import java.util.Scanner;

class HanoiTowers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n < 3 || n > 10) {
            throw new IllegalArgumentException("n must be between 3 and 10");
        }

        int from = 1;
        int to = 3;

        HanoiTowers hanoiTowers = new HanoiTowers();
        System.out.println((int) (Math.pow(2, n) - 1));
        hanoiTowers.decision(n, from, to);
    }

    private void decision(int n, int from, int to) {
        System.out.printf("%d %d%n", from, to);
        if (n == 1) {
            return;
        }
        int unused = 6 - from - to;
        decision(n - 1, from, unused);
        decision(n - 1, unused, to);
    }
}