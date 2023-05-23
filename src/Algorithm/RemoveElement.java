package Algorithm;

public class  RemoveElement {
    public int removeElement(int[] nums, int val) {
       int p=0,q=1;
       for(;p<nums.length;p++){
           if(nums[q]!=val){
               nums[p] = nums[q];
               q++;
           }
       }
       return q;
    }
}
