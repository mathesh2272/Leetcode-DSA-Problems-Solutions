class Solution {
    public int minimumDeletions(String word, int k) {
        char[] ch = word.toCharArray();
        int n = ch.length;
        int[] hash = new int[26];
        for(int i = 0 ; i < n ; i++){
            hash[ch[i] - 'a']++;
        }      
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < 26 ; i++){
            if(hash[i] != 0){
                list.add(hash[i]);
            }
        }
        int[] nums = list.stream().mapToInt(a -> a).toArray();
        int size = nums.length;
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < size ; i++){
            int op = 0;
            for(int j = 0 ; j < size ; j++){
                if(nums[i] > nums[j]){
                    op += nums[j];
                }
                else{
                    op += Math.max(0, (nums[j] - nums[i] - k));
                }
            }
            ans = Math.min(ans, op);
        }  
        return ans;
    }
}