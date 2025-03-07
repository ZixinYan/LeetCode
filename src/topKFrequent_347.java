import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class topKFrequent_347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] m, int[] n){
                return m[1] - n[1];
            }
        });
        for(int num: map.keySet()){
            if(pq.size()<k){
                pq.add(new int[]{num,map.get(num)});
            }else{
                pq.add(new int[]{num,map.get(num)});
                pq.poll();
            }
        }

        int[] res = new int[k];
        for(int i = 0;i<k;i++){
            res[i]= pq.poll()[0];
        }
        return res;
    }
}
