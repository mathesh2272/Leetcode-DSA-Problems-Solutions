class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();
        int n = messages.length;
        String ans = "";
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            int len = messages[i].split(" ").length;
            map.put(senders[i], map.getOrDefault(senders[i], 0) + len);
            int words = map.get(senders[i]);
            if(max < words || (max == words && ans.compareTo(senders[i]) < 0)){
                max = words;
                ans = senders[i];
            }
        }
        return ans;
    }
}