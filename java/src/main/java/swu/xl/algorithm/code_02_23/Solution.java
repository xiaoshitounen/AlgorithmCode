package swu.xl.algorithm.code_02_23;

public class Solution {
    /**
     * 02-23-xl test
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target){

        int length = nums.length;
        int[] source = new int[2];

        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if(nums[i] + nums[j] == target){
                    source[0] = i;
                    source[1] = j;
                    return source;
                }
            }
        }

        return source;
    }

}
