import java.util.Scanner;

public class SumOfTwoStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String first = sc.next();
        String second = sc.next();

        System.out.println(sumOfTwoStrings(n, first, second));
    }

    private static String sumOfTwoStrings(int n, String first, String second) {
        char[] firstCharArray = first.toCharArray();
        char[] secondCharArray = second.toCharArray();
        char[] result = new char[2 * n];
        for (int i = 0; i < n; i++) {
            result[i * 2] = firstCharArray[i];
            result[i * 2 + 1] = secondCharArray[i];
        }
        return new String(result);
    }

}