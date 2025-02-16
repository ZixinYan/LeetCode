import java.util.Comparator;
import java.util.PriorityQueue;

public class replaceElements_1299 {
    /* 直接运算
    public int[] replaceElements(int[] arr) {
        for(int j=0;j<arr.length;j++){
            arr[j] = 0;
            for(int i = j + 1; i < arr.length;i++){
                arr[j] = Math.max(arr[j], arr[i]);
            }
        }
        arr[arr.length-1] = -1;
        return arr;
    }

     */

    public int[] replaceElements(int[] arr) {
        int[] ans = new int[arr.length];
        ans[arr.length - 1] = -1;
        for(int i = arr.length - 2; i >= 0; i--){
            ans[i] = Math.max(ans[i+1], arr[i+1]);
        }
        return ans;
    }
}
