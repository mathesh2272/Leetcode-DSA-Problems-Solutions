class Solution {
    public String minimizeStringValue(String s) {
        char c = 'a';
        Map<Character, Integer> map = new HashMap<>();
        while(c <= 'z'){
            map.put(c, 0);
            c++;
        }
        char[] ch = s.toCharArray();
        int n = ch.length; 
        for(int i = 0 ; i < n ; i++){
            if(ch[i] != '?'){
                map.put(ch[i], map.get(ch[i]) + 1);
            }
        }
        c = 'a';
        int val = 1;
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while(i < n) {
            if(ch[i] == '?') {
                if(map.get(c) < val) {
                    sb.append(c);
                    map.put(c, map.get(c) + 1);
                    i++;
                }
                if(c == 'z'){
                    val++;
                    c = 'a';
                } 
                else{
                    c++;
                }
            } 
            else{
                i++;
            }
        }
        char[] tmp = new String(sb).toCharArray();
        Arrays.sort(tmp);
        int ind = 0;
        i = 0;
        for(i = 0 ; i < n ; i++){
            if(ch[i] == '?'){
                ch[i] = tmp[ind++];
            } 
        }
        return new String(ch);
    }
}