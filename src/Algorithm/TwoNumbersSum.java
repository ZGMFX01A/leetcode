package Algorithm;

import java.util.HashMap;
import java.util.Map;

public class TwoNumbersSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        map.put(nums[0], 0);
        for (int i=1; i<nums.length; i++) {

            if (map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
//     for (int i = 0; i < nums.length-1; i++){
//        for (int j = i+1; j < nums.length;j++){
//            if (target == nums[j]+nums[i]){
//                return  new int[]{i, j};
//            }
}
