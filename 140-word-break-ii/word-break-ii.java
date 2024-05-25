class Solution {
    Set<String> set;
    List<String> ms;
    List<String> list;
    public List<String> track(String s, int ind, int n){
        if(ind >= n){
            StringBuilder sb = new StringBuilder();
            for(String m : list){
                sb.append(m);
                sb.append(" ");
            }
            ms.add(new String(sb).trim());
            return ms;
        }
        for(int i = ind ; i < n ; i++){
            String str = s.substring(ind, i + 1);
            if(set.contains(str)){
                list.add(str);
                track(s, i + 1, n);
                list.remove(list.size() - 1);
            }
        }
        return ms;
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        list = new ArrayList<>();
        ms = new ArrayList<>();
        set = new HashSet<>(wordDict);
        return track(s, 0, s.length());
    }
}