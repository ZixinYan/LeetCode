import java.util.Arrays;

public class maxConsecutive_2274 {
    public int maxConsecutive(int bottom, int top, int[] special) {
        if(special.length == top - bottom + 1){
            return 0;
        }
        Arrays.sort(special);
        int res = special[0] - bottom;
        int now = bottom;
        for(int i = 0;i < special.length;i++){
            int temp = special[i] - now - 1 ;
            if(temp > res){
                res = temp;
            }
            now = special[i];
        }
        if(top - now > res){
            res = top - now;
        }
        return res;
    }

}
