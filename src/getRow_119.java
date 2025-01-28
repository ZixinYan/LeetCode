import java.util.ArrayList;
import java.util.List;

public class getRow_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(1);
        for(int i = 1; i <= rowIndex; i++) {
            ans.add(0);
            for(int j = i; j > 0; --j) {
                ans.set(j, ans.get(j) + ans.get(j - 1));
            }
        }
        return ans;
    }
}
