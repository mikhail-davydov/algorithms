import java.util.Scanner;

class Rocks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        Rocks rocks = new Rocks();
        System.out.println(rocks.decision(n, m));
    }

    private String decision(int n, int m) {
        return (n % 2 == 0 && m % 2 == 0) ? "Lose" : "Win";
    }
}