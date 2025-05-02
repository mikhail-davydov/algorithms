import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int intervalCount = scanner.nextInt();
        List<Pair> intervals = new ArrayList<>(intervalCount);
        for (int i = 0; i < intervalCount; i++) {
            intervals.add(new Pair(scanner.nextInt(), scanner.nextInt()));
        }
        BookRoom bookRoom = new BookRoom();
        System.out.println(bookRoom.decision(intervals, 0));
    }

    private int decision(List<Pair> intervals, int count) {
        intervals.sort(Pair::compare);

        if (intervals.isEmpty()) {
            return count;
        }

        Pair first = intervals.get(0);
        List<Pair> rest = new ArrayList<>();
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start > first.end) {
                rest.add(intervals.get(i));
            }
        }
        return decision(rest, count + 1);
    }

    private static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        private static int compare(Pair o1, Pair o2) {
            return o1.end > o2.end ? 1 : -1;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

}