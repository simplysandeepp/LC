class Solution {
    public boolean uniformArray(int[] nums1) {
        int odd=0, n=nums1.length;
        int min = Integer.MAX_VALUE, minE = Integer.MAX_VALUE;
        for(int x : nums1){
            if(x%2 != 0){
                odd++;
                min = Math.min(min, x);
            }else {
                minE = Math.min(minE, x);
            }
        }
        if(odd==0 || odd==n) return true;
        if(minE - min >= 1) return true;
        return false;
    }
}