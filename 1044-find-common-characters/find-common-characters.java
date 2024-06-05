class Solution {
    public List<String> commonChars(String[] words) {
        int n = words.length;
        int[][] hash = new int[n][26];
        for(int i = 0 ; i < n ; i++){
            for(char c : words[i].toCharArray()){
                hash[i][c - 'a']++;
            }
        }
        List<String> list = new ArrayList<>();
        char[] ch = words[0].toCharArray();
        int len = ch.length;
        Set<Character> set = new HashSet<>();
        for(int i = 0 ; i < len ; i++){
            set.add(ch[i]);
        }
        for(char c : set){
            int min = 101;
            boolean flag = true;
            int ind = c - 'a';
            for(int j = 0 ; j < n ; j++){
                if(hash[j][ind] > 0){
                    if(min > hash[j][ind]){
                        min = hash[j][ind];
                    }
                }
                else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                String s = String.valueOf(c);
                while(min-- > 0){
                    list.add(s);
                }
            }
        }
        return list;
    }
}