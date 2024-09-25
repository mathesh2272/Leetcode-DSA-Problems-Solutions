class Trie{
    Trie[] node;
    boolean isEnd;
    int prefix;
    public Trie(){
        node = new Trie[26];
        isEnd = false;
        prefix = 0;
    }
    public void insert(char[] ch, Trie root){
        Trie curr_root = root;
        int n = ch.length;
        int ind = 0;
        for(int i = 0 ; i < n ; i++){
            ind = ch[i] - 'a';
            if(curr_root.node[ind] == null){
                curr_root.node[ind] = new Trie();
            }
            curr_root = curr_root.node[ind];
            curr_root.prefix++;
        }
        curr_root.isEnd = true;
    }
    public int startsWith(char[] ch, Trie root){
        Trie curr_root = root;
        int n = ch.length;
        int ind = 0;
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            ind = ch[i] - 'a';
            if(curr_root.node[ind] == null){
                return count;
            }
            curr_root = curr_root.node[ind];
            count += curr_root.prefix;
        }
        return count;
    }
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        Trie root = new Trie();
        for(int i = 0 ; i < n ; i++){
            root.insert(words[i].toCharArray(), root);
        }
        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++){
            ans[i] = root.startsWith(words[i].toCharArray(), root);
        }
        return ans;
    }
}