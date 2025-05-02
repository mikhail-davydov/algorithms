import java.util.Scanner;

class LomutoPartition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n < 1 || n > 100000) {
            return;
        }

        int[] ints = fillInput(sc, n);
        int[] lomuto = decision(ints);
        printResult(lomuto);
    }

    private static int[] decision(int[] ints) {
        int i = 1, j = 1, pivot = ints[0];
        while (i < ints.length && j < ints.length) {
            if (ints[i] < pivot) {
                swapElements(ints, j, i);
                j++;
            }
            i++;
        }
        swapElements(ints, j - 1, 0);
        return ints;
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