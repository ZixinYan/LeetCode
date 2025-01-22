import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class maxCoins_1561 {
    public int maxCoins(int[] piles) {
        int res = 0;
        Arrays.sort(piles);
        Deque<Integer> deque = new LinkedList<>();
        for(int num: piles){
            deque.addLast(num);
        }
        while(!deque.isEmpty()){
            int max = deque.removeLast();
            int min = deque.removeFirst();
            res = res + deque.removeLast();
        }
        return res;
    }
}
