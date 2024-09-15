class Solution {
    public int findTheLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int ans = 0;
        int mask = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0 ; i < n ; i++){
            if(ch[i] == 'a'){
                mask = mask ^ 1;
            }
            if(ch[i] == 'e'){
                mask = mask ^ 2;
            }
            if(ch[i] == 'i'){
                mask = mask ^ 4;
            }
            if(ch[i] == 'o'){
                mask = mask ^ 8;
            }
            if(ch[i] == 'u'){
                mask = mask ^ 16;
            }
            if(map.containsKey(mask)){
                ans = Math.max(ans, i - map.get(mask));
            }
            else{
                map.put(mask, i);
            }
        }
        return ans;
    }
}