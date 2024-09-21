class Trie{
    Trie[] node;
    boolean isEnd;
    public Trie(){
        node = new Trie[10];
        isEnd = false;
    }
}
class Solution {
    public void insert(String s, Trie root){
        char[] ch = s.toCharArray();
        int n = ch.length;
        Trie curr = root;
        for(int i = 0 ; i < n ; i++){
            int key = ch[i] - '0';
            if(curr.node[key] == null){
                curr.node[key] = new Trie();
            }
            curr = curr.node[key];
        }
        curr.isEnd = true;
    }
    public List<Integer> displayNumber(Trie root, int val, List<Integer> ans){
        if(root.isEnd){
            ans.add(val);
        }
        for(int i = 0 ; i < 10 ; i++){
            if(root.node[i] != null){
                displayNumber(root.node[i], val * 10 + i, ans);
            }
        }
        return ans;
    }
    public List<Integer> lexicalOrder(int n) {
        Trie root = new Trie();
        for(int i = 1 ; i <= n ; i++){
            insert(String.valueOf(i), root);
        }
        List<Integer> ans = new ArrayList<>();
        return displayNumber(root, 0, ans);
    }
}