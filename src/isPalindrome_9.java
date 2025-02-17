public class isPalindrome_9 {
    public boolean isPalindrome(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        int end = arr.length - 1;
        int start = 0;
        while (start < end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
