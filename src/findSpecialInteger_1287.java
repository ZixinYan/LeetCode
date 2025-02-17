import java.util.HashMap;

public class findSpecialInteger_1287 {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int min = n / 4;
        for (int i = 0; i < n; i++) {
            if (i+min<n && arr[i] == arr[i + min]) {
                return arr[i];
            }
        }
        return arr[n - 1];
    }
}
