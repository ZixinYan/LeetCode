import java.util.*;
import java.util.stream.Collectors;

public class groupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String sortedStr = new String(temp);

            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
