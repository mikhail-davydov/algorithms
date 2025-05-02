import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int permutaiontsCount = 1;
        for (int j = 2; j <= i; j++) {
            permutaiontsCount *= j;
        }
        System.out.println(permutaiontsCount);
    }
}