import java.util.HashMap;
import java.util.HashSet;

public class countBalls_1742 {
    public int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int i = lowLimit; i <= highLimit; i++) {
            int count = 0;
            int temp = i;
            while(temp != 0){
                count += temp % 10;
                temp /= 10;
            }

            map.put(count, map.getOrDefault(count, 0) + 1);
            res = Math.max(res, map.get(count));
        }
        return res;
    }
}
