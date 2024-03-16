class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        int max = 0;
        map.put(0, -1);
        for(int i = 0 ; i < n ; i++){
            cnt += nums[i] == 0 ? -1 : 1;
            if(map.get(cnt) != null){
                max = Math.max(max, i - map.get(cnt));
            }
            else{
                map.put(cnt, i);
            }
        }
        return max;
    }
}