import java.util.Scanner;

public class SumOfTwoPolynoms {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n < 0 || n > 10) {
            return;
        }
        int[] aArray = fillInput(sc, n);

        int m = sc.nextInt();
        if (m < 0 || m > 10) {
            return;
        }
        int[] bArray = fillInput(sc, m);

        printResults(n, aArray, m, bArray);

    }

    private static void printResults(int n, int[] aArray, int m, int[] bArray) {
        int last = Math.max(n, m);
        System.out.println(last);

        int[] result = new int[Math.max(aArray.length, bArray.length)];
        int lastA = Math.min(aArray.length - 1, last);
        int lastB = Math.min(bArray.length - 1, last);

        while (lastA >= 0 && lastB >= 0) {
            result[last] = sumOfTwoDigits(aArray[lastA], bArray[lastB]);
            lastA--;
            lastB--;
            last--;
        }

        if (lastA >= 0) {
            while (lastA >= 0) {
                result[lastA] = aArray[lastA];
                lastA--;
            }
        }

        if (lastB >= 0) {
            while (lastB >= 0) {
                result[lastB] = bArray[lastB];
                lastB--;
            }
        }

        printArray(result);
    }

    private static int sumOfTwoDigits(int first, int second) {
        return first + second;
    }

    private static void printArray(int[] ints) {
        StringBuilder output = new StringBuilder();
        for (int anInt : ints) {
            output.append(anInt).append(" ");
        }
        System.out.println(output);
    }

    private static int[] fillInput(Scanner sc, int n) {
        int capacity = n + 1;
        int[] array = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }

}