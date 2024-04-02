class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int n = ch1.length;
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            if(map.containsKey(ch1[i])){
                if(map.get(ch1[i]) != ch2[i]){
                    return false;
                }
            }
            else{
                if(map.containsValue(ch2[i])){
                    return false;
                }
                map.put(ch1[i], ch2[i]);
            }
        }
        return true;
    }
}