import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        checkInput(n);
        int[] ints = fillInput(sc, n);
        int[] sorted = decision(ints);
        printResult(sorted);
    }

    private static int[] decision(int[] ints) {
        if (ints.length == 1) {
            return ints;
        }

        int[] first = new int[ints.length / 2];
        System.arraycopy(ints, 0, first, 0, ints.length / 2);
        int[] second = new int[ints.length - ints.length / 2];
        System.arraycopy(ints, ints.length / 2, second, 0, ints.length - ints.length / 2);

        return mergeArrays(decision(first), decision(second));
    }

    private static int[] mergeArrays(int[] first, int[] second) {
        int[] merged = new int[first.length + second.length];

        int i = 0, j = 0, k = 0;
        while (i < first.length) {
            while (j < second.length) {
                if (i == first.length) {
                    break;
                }
                if (first[i] < second[j]) {
                    merged[k++] = first[i++];
                } else {
                    merged[k++] = second[j++];
                }
            }
            if (j == second.length) {
                break;
            }
        }

        if (i < first.length) {
            System.arraycopy(first, i, merged, k, first.length - i);
        }

        if (j < second.length) {
            System.arraycopy(second, j, merged, k, second.length - j);
        }

        return merged;
    }

    private static void printResult(int[] ints) {
        StringBuilder output = new StringBuilder();
        for (int anInt : ints) {
            output.append(anInt).append(" ");
        }
        System.out.println(output);
    }

    private static int[] fillInput(Scanner sc, int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }

    private static void checkInput(int n) {
        if (n < 1 || n > 100000) {
            throw new IllegalArgumentException("n must be in range [1, 100000]");
        }
    }

}