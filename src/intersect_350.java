// 普通的Hash表题

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class intersect_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                tempList.add(num);
                map.put(num, map.get(num) - 1); // 减少计数
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }
        return tempList.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        int[] num1 = {4,7,9,7,6,7};
        int[] num2 = {5,0,0,6,1,6,2,2,4};
        intersect_350 intersect = new intersect_350();
        System.out.println(Arrays.toString(intersect.intersect(num1, num2)));
    }
}
