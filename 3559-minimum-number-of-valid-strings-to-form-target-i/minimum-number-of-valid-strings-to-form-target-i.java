class Trie{
    Trie[] node;
    boolean isEnd;
    public Trie(){
        node = new Trie[26];
        isEnd = false;
    }
}
class Solution {
    int max = Integer.MAX_VALUE / 2;
    void addString(char[] ch, Trie root){
        Trie curr = root;
        int n = ch.length;
        for(int i = 0 ; i < n ; i++){
            int key = ch[i] - 'a';
            if(curr.node[key] == null){
                curr.node[key] = new Trie();
            }
            curr = curr.node[key];
        }
        curr.isEnd = true;
    }
    Integer[] dp;
    int helper(char[] ch, int i, int n, Trie root){
        if(i == n){
            return 0;
        }
        if(dp[i] != null){
            return dp[i];
        }
        int ans = max;
        Trie curr = root;
        for(int j = i ; j < n ; j++){
            int key = ch[j] - 'a';
            if(curr.node[key] == null){
                break;
            }
            curr = curr.node[key];
            ans = Math.min(ans, 1 + helper(ch, j + 1, n, root));
            // System.out.println(ans);
        }
        return dp[i] = ans;
    }
    public int minValidStrings(String[] words, String target) {
        Trie root = new Trie();
        int n = words.length;
        for(int i = 0 ; i < n ; i++){
            addString(words[i].toCharArray(), root);
        }
        n = target.length();
        dp = new Integer[n];
        int ans = helper(target.toCharArray(), 0, n, root);
        return ans == max ? -1 : ans;
    }
}