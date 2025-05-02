import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.logging.Logger;

public class MaxPairwiseProduct {

    private final static Logger log = Logger.getLogger(MaxPairwiseProduct.class.getName());

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();

//        int m = scanner.nextInt();
//        stressTest(n, m);

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        log.info("numbers: " + Arrays.toString(numbers));

        System.out.println(getMaxPairwiseProductFast(numbers));
    }

    private static long getMaxPairwiseProductNaive(int[] numbers) {
        long max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; first++) {
            for (int second = first + 1; second < n; second++) {
                max_product = Math.max(max_product,
                        (long) numbers[first] * numbers[second]);
            }
        }

        return max_product;
    }

    private static long getMaxPairwiseProductFast(int[] numbers) {
        int i = numbers.length - 1;
        Arrays.sort(numbers);
        while (i > 0) {
            int product = numbers[i] * numbers[i - 1];
            if (product > 0) {
                return product;
            }
            i--;
        }
        return 0;
    }

    private static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    private static void stressTest(int n, int m) {
        while (true) {
            int arraySize = (int) (Math.random() * n + 2); // between 2 and n
            int[] testArray = new int[arraySize];
            for (int j = 0; j < arraySize; j++) {
                testArray[j] = (int) (Math.random() * m);
            }

            long resultNaive = getMaxPairwiseProductNaive(testArray);
            long resultFast = getMaxPairwiseProductFast(testArray);

            if (resultFast != resultNaive) {
                log.info("testArray: " + Arrays.toString(testArray));
                log.info("resultFast: " + resultFast + ", resultNaive: " + resultNaive);
                return;
            }
        }
    }

}