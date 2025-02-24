import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderedStream_1656 {
    private HashMap<Integer, String> map;
    int ptr = 1;
    public OrderedStream_1656(int n) {
        map = new HashMap<>();
    }

    public List<String> insert(int idKey, String value) {
        map.put(idKey, value);
        List<String> list = new ArrayList<>();
        if(ptr == idKey){
            while(map.containsKey(ptr)){
                list.add(map.get(ptr));
                ptr++;
            }
        }
        return list;
    }
}
