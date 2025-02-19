import java.util.List;

public class maxDistance_624 {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int res = 0;
        for (int i = 1; i < arrays.size(); i++) {
            int n = arrays.get(i).size();
            res = Math.max(res, Math.max(Math.abs(arrays.get(i).get(n - 1) - min),
                    Math.abs(max- arrays.get(i).get(0))));
            min = Math.min(min, arrays.get(i).get(0));
            max = Math.max(max, arrays.get(i).get(n - 1));
        }
        return res;
    }
}
