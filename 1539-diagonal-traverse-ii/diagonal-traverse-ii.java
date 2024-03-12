class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = nums.size();
        int cnt = 0;
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        int size = 0;
        for(List<Integer> list : nums){
            int val = cnt;
            for(int ele : list){
                map.putIfAbsent(val, new ArrayList<>());
                map.get(val).add(ele);
                val++;
                size++;
            }
            cnt++;
        }
        int[] ans = new int[size];
        cnt = 0;
        for(List<Integer> list : map.values()){
            Collections.reverse(list);
            for(int ele : list){
                ans[cnt++] = ele;    
            }
        }
        return ans;
    }
}