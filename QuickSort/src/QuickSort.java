import java.util.Scanner;

public class QuickSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n < 1 || n > 100000) {
            return;
        }

        int[] ints = fillInput(sc, n);
        decision(ints, 0, ints.length - 1);
        printResult(ints);
    }

    private static void decision(int[] numbers, int from, int to) {
        int left = from;
        int right = to;
        int pivot = numbers[from + (to - from) / 2];
        while (left <= right) {
            while (numbers[left] < pivot) {
                left++;
            }
            while (numbers[right] > pivot) {
                right--;
            }
            if (left <= right) {
                if (left != right) {
                    swapElements(numbers, left, right);
                }
                left++;
                right--;
            }
        }

        if (from < right) {
            decision(numbers, from, right);
        }
        if (left < to) {
            decision(numbers, left, to);
        }
    }

    private static void swapElements(int[] ints, int from, int to) {
        int temp = ints[from];
        ints[from] = ints[to];
        ints[to] = temp;
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

}