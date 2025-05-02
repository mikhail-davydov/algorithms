import java.util.Scanner;

class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n < 1 || n > 1000) {
            throw new IllegalArgumentException("n must be between 1 and 1000");
        }

        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = sc.nextInt();
        }

        SelectionSort sort = new SelectionSort();
        printResult(sort.decision(ints));
    }

    private int[] decision(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                exchangeElements(ints, j, i);
            }
        }
        return ints;
    }

    private void exchangeElements(int[] ints, int j, int i) {
        if (ints[j] < ints[i]) {
            ints[i] += ints[j];
            ints[j] = ints[i] - ints[j];
            ints[i] = ints[i] - ints[j];
        }
    }

    private static void printResult(int[] ints) {
        StringBuilder output = new StringBuilder();
        for (int anInt : ints) {
            output.append(anInt).append(" ");
        }
        System.out.println(output);
    }
}