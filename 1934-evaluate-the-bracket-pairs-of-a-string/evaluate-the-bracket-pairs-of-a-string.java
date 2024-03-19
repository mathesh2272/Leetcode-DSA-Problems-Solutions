class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for(List<String> list : knowledge){
            map.put(list.get(0), list.get(1));
        }
        char[] ch = s.toCharArray();
        int n = ch.length;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < n){
            if(ch[i] == '('){
                i++;
                StringBuilder ms = new StringBuilder();
                while(i < n && ch[i] != ')'){
                    ms.append(ch[i++]);
                }
                i++;
                String str = map.get(new String(ms));
                sb.append(str == null ? "?" : str);
            }
            else{
                sb.append(ch[i]);
                i++;
            }
        }
        return new String(sb);
    }
}