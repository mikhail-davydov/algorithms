import java.util.Scanner;

class SumOfTwoDigits {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        System.out.println(sumOfTwoDigits(a, b));
    }

    private static int sumOfTwoDigits(int first, int second) {
        return first + second;
    }

}