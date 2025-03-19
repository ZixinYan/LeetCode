class Solution {
    /*
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            list.add(nums[0]);
            if(nums[i] != nums[i-1]){
                list.add(nums[i]);
            }else{
                temp.add(nums[i]);
            }
        }
        res.add(list);

        while(temp.size() > 0){
            list = new ArrayList<>();
            list.add(temp.get(0));
            for (int i = 1; i < temp.size(); i++) {
                if(nums[i] != nums[i-1]){
                    list.add(nums[i]);
                    temp.remove(nums[i]);
                }
            }
            res.add(list);
        }

        return res;
    }

     */

}


import java.util.*;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // 统计每个数字的出现次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 逐层构造结果
        while (!map.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                list.add(entry.getKey());

                // 更新计数
                if (entry.getValue() == 1) {
                    iterator.remove();  // 安全删除
                } else {
                    entry.setValue(entry.getValue() - 1);
                }
            }
            res.add(list);
        }
        return res;
    }
}
