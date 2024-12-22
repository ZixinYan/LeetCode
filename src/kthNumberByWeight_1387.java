import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class kthNumberByWeight_1387 {
    private static final int MAX = 1000000;
    private static int[] arr = new int[MAX];

    // Initialize the memoization array with -1
    static {
        Arrays.fill(arr, -1);
    }

    // Calculate the Collatz sequence weight for a number
    private static int calc(int x) {
        if (x == 1) {
            return 1;
        }
        if (arr[x] != -1) {
            return arr[x];
        }
        int res;
        if (x % 2 == 0) {
            res = 1 + calc(x / 2);
        } else {
            res = 1 + calc(x * 3 + 1);
        }
        arr[x] = res;
        return res;
    }

    // Custom comparator to sort by Collatz sequence weight, then by number value
    private static class NumberComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer num1, Integer num2) {
            int weight1 = calc(num1);
            int weight2 = calc(num2);
            if (weight1 != weight2) {
                return weight1 - weight2;
            } else {
                return num1 - num2;
            }
        }
    }

    // Get the k-th number in the sorted array based on the Collatz sequence weight
    public static int getKth(int lo, int hi, int k) {
        Integer[] numbers = new Integer[hi - lo + 1];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = lo + i;
        }
        Arrays.sort(numbers, new NumberComparator());
        return numbers[k - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the lower bound, upper bound and k:");
        int lo = scanner.nextInt();
        int hi = scanner.nextInt();
        int k = scanner.nextInt();
        int result = getKth(lo, hi, k);
        System.out.println("The " + k + "-th number in the sorted sequence is: " + result);
    }
}
