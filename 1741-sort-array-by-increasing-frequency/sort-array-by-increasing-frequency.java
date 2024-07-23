class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        } 
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> {
            int k1 = map.get(a);
            int k2 = map.get(b);
            return k1 == k2 ? b - a : k1 - k2;
        });
        int i = 0;
        for(int val : list){
            int k = map.get(val);
            while(k-- > 0){
                nums[i++] = val;
            }
        }
        return nums;
    }
}