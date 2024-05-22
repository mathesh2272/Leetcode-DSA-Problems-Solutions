class Solution {
    List<List<String>> list;
    public boolean isPalindrome(String s){
        char[] ch = s.toCharArray();
        int left = 0;
        int right = ch.length - 1;
        while(left <= right){
            if(ch[left++] != ch[right--]){
                return false;
            }
        }  
        return true;
    }
    public List<List<String>> track(String s, int ind, int n, List<String> partition){
        if(ind == n){
            list.add(new ArrayList<>(partition));
            return list;
        }
        for(int i = ind ; i < n ; i++){
            String ms = s.substring(ind, i + 1);
            if(isPalindrome(ms)){
                partition.add(ms);
                track(s, i + 1, n, partition);
                partition.remove(partition.size() - 1);
            }
        }
        return list;
    }
    public List<List<String>> partition(String s) {
        list = new ArrayList<>();
        return track(s, 0, s.length(), new ArrayList<>());
    }
}