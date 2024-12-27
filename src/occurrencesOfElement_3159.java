//  找到特定位置的元素，返回其下标，如果没有找到返回-1
//  时间复杂度O(n)，空间复杂度O(1)
//  https://leetcode.com/problems/occurrences-of-element-in-array/discuss/1009807/Java-Simple-Brute-Force

public class occurrencesOfElement_3159 {

    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int max = findMax(queries);
        int[] index = new int[max + 1];
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == x){
                count++;
                if(count > max){
                    break;
                }else{
                    index[count] = i;
                }
            }
        }
        int[] res = new int[queries.length];
        for(int i = 0;i<queries.length;i++){
            if(count < queries[i]) {
                res[i] = -1;
            }else{
                res[i] = index[queries[i]];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        occurrencesOfElement_3159 ooe = new occurrencesOfElement_3159();
        int[] nums = {1,3,1,7};
        int[] queries = {1,3,2,4};
        int x = 1;
        int[] res = ooe.occurrencesOfElement(nums, queries, x);
        for(int i = 0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
