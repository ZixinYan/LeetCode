import java.util.ArrayList;
import java.util.HashMap;

public class findBall_1706 {
    /* 利用HashMap
    public static int[] findBall(int[][] grid) {
        HashMap<Integer,Integer> map = new HashMap<>();
        //init
        for(int i = 0;i<grid[0].length;i++){
            map.put(i,i);
        }
        for(int[] now : grid){
            for(int i = 0;i<now.length;i++){
                if(map.get(i) == -1){
                    continue;
                }
                int pos = map.get(i);
                if((pos+now[pos])<0 || (pos+now[pos]) > now.length-1){
                    map.put(i,-1);
                }else if(pos <= now.length - 1 && now[pos] == 1 && now[pos + 1] == -1) {
                    map.put(i,-1);
                }else if(pos >= 1 && now[pos] == -1 && now[pos - 1] == 1){
                    map.put(i,-1);
                }else{
                    map.put(i,pos+now[pos]);
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        return list.stream().mapToInt(i->i).toArray();
    }
     */

    // 利用列
    public static int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] ans = new int[n];
        for (int j = 0; j < n; j++) {
            int col = j;  // 球的初始列
            for (int[] row : grid) {
                int dir = row[col];
                col += dir;  // 移动球
                if (col < 0 || col == n || row[col] != dir) {  // 到达侧边或 V 形
                    col = -1;
                    break;
                }
            }
            ans[j] = col;  // col >= 0 为成功到达底部
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,1,1,-1,-1},
                {1,1,1,-1,-1},
                {-1,-1,-1,1,1},
                {1,1,1,1,-1},
                {-1,-1,-1,-1,-1}
        };
        for(int i :findBall_1706.findBall(grid)){
            System.out.println(i);
        }
    }
}
