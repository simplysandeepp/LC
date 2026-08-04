class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = 101, max = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0 ; i < nums.length ; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            set.add(nums[i]);
        }

        List<Integer> list = new ArrayList<>();

        for(int i = min ; i <= max ; i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }

        return list;
    }
}