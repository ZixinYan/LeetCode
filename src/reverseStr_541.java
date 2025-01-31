import java.util.Collections;
import java.util.Stack;

public class reverseStr_541 {
    /* 利用stack解决，但是时间开销和空间开销有点儿大
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i += 2 * k) {
            int end = Math.min(i + k, n);
            Stack<Character> stack = new Stack<>();
            for (int j = i; j < end; j++) {
                stack.push(s.charAt(j));
            }
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            int end2 = Math.min(i + 2 * k, n);
            for (int j = end; j < end2; j++) {
                sb.append(s.charAt(j));
            }
        }
        return sb.toString();
    }

     */

    // 利用双指针解决
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while (i < n) {
            int left = i;
            int right = i + k - 1;
            if (right >= n) {
                right = n - 1;
            }
            while (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            i += 2 * k;
        }
        return new String(arr);
    }
}
