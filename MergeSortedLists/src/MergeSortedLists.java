import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeSortedLists {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // input lists count

        if (n < 1 || n > 20) {
            throw new IllegalArgumentException("n must be between 1 and 20");
        }

        List<List<Integer>> intsLists = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            int m = in.nextInt(); // list elements count
            List<Integer> ints = new ArrayList<>(m);
            for (int j = 0; j < m; j++) {
                ints.add(in.nextInt()); // fill in lists
            }
            intsLists.add(ints);
        }

        MergeSortedLists mergeSortedLists = new MergeSortedLists();
        printResult(mergeSortedLists.decision(intsLists));

    }

    private List<Integer> decision(List<List<Integer>> intsLists) {
        if (intsLists.size() == 1) {
            return intsLists.get(0);
        }

        if (intsLists.size() == 2) {
            return mergeLists(intsLists.get(0), intsLists.get(1));
        }

        int median = intsLists.size() / 2;
        List<List<Integer>> firstHalf = new ArrayList<>(median);
        List<List<Integer>> secondHalf = new ArrayList<>(intsLists.size() - median);
        for (int i = 0; i < intsLists.size(); i++) {
            if (i < median) {
                firstHalf.add(intsLists.get(i));
            } else {
                secondHalf.add(intsLists.get(i));
            }
        }
        return mergeLists(decision(firstHalf), decision(secondHalf));
    }

    private List<Integer> mergeLists(List<Integer> first, List<Integer> second) {
        List<Integer> merged = new ArrayList<>(first.size() + second.size());

        int i = 0;
        int j = 0;
        while (i < first.size()) {
            while (j < second.size()) {
                if (i == first.size()) {
                    break;
                }
                if (first.get(i) < second.get(j)) {
                    merged.add(first.get(i));
                    i++;
                } else {
                    merged.add(second.get(j));
                    j++;
                }
            }
            if (j == second.size()) {
                break;
            }
        }

        if (i < first.size()) {
            merged.addAll(first.subList(i, first.size()));
        }

        if (j < second.size()) {
            merged.addAll(second.subList(j, second.size()));
        }

        return merged;
    }

    private static void printResult(List<Integer> sortedList) {
        StringBuilder output = new StringBuilder();
        for (int anInt : sortedList) {
            output.append(anInt).append(" ");
        }
        System.out.println(output);
    }
}