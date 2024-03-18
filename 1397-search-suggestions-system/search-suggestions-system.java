class Trie{
    Trie[] node;
    List<String> words;
    boolean isEnd;
    public Trie(){
        node = new Trie[26];
        words = new ArrayList<>();
        isEnd = false;
    }
    public void insert(String s, Trie root){
        Trie tmp_root = root;
        char[] ch = s.toCharArray();
        int n = ch.length;
        for(int i = 0 ; i < n ; i++){
            int ind = ch[i] - 'a';
            if(tmp_root.node[ind] == null){
                tmp_root.node[ind] = new Trie();
            }
            tmp_root = tmp_root.node[ind];
            if(tmp_root.words.size() < 3){
                tmp_root.words.add(s);
            }
        }
        tmp_root.isEnd = true;
    }
}
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        int n = products.length;
        Trie root = new Trie();
        Arrays.sort(products);
        for(int i = 0 ; i < n ; i++){
            root.insert(products[i], root);
        }
        char[] ch = searchWord.toCharArray();
        n = ch.length;
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(root != null){
                root = root.node[ch[i] - 'a'];
            }
            ans.add(root == null ? new ArrayList<>() : root.words);
        }
        return ans;
    }
}