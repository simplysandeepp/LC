class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        int n = nums.length;

        int curr=0;
        int prev=0;
        long res=0;

        for(int i=0; i<n; i++){
            curr=target[i]-nums[i];;

            if((curr<0 && prev>0) || (curr>0 && prev<0)){
                res+=Math.abs(curr);
            }else if(Math.abs(curr)>Math.abs(prev)){
                res+=Math.abs(curr-prev);
            }

            prev=curr;
        }
        return res;
    }
}