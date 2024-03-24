class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;
        long[] ans = new long[n];
        Map<Integer, Long> map = new HashMap<>();
        TreeMap<Long, PriorityQueue<Integer>> countID = new TreeMap<>();
        long maxCount = 0;
        for(int i = 0 ; i < n ; i++) {
            int id = nums[i];
            long count = map.getOrDefault(id, 0L);
            if(count > 0) {
                countID.get(count).remove(id);
                if(countID.get(count).isEmpty()) {
                    countID.remove(count);
                }
            }
            count += freq[i];
            map.put(id, count);
            if(count > 0) {
                countID.putIfAbsent(count, new PriorityQueue<>());
                countID.get(count).add(id);
            }
            maxCount = countID.isEmpty() ? 0L : countID.lastKey();
            ans[i] = maxCount;
        }
        return ans;
    }
}