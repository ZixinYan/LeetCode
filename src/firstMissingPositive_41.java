class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i < n;i++){
            if(nums[i] > 0){
                set.add(nums[i]);
            }
        }
        int x = 1;
        while(set.contains(x)){
            x++;
        }
        return x;
    }
}

// faster solution
class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        // simulate the hash table
        for(int i = 0; i < length; i++){
            while(nums[i] > 0 && nums[i] < length && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }

        for(int i = 0; i < length; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }

        return length + 1;
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
