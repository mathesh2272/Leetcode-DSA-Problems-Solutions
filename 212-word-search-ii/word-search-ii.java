class Trie{
    Trie[] node;
    String word;
    boolean isEnd;
    public Trie(){
        node = new Trie[26];
        word = "";
        isEnd = false;
    }
    public void insert(String s, Trie root){
        char[] ch = s.toCharArray();
        int n = ch.length;
        Trie tmp_root = root;
        for(int i = 0 ; i < n ; i++){
            int ind = ch[i] - 'a';
            if(tmp_root.node[ind] == null){
                tmp_root.node[ind] = new Trie();
            }
            tmp_root = tmp_root.node[ind];
        }
        tmp_root.word = s;
        tmp_root.isEnd = true;
    }
    public void track(char[][] board, int row, int col, int n, int m, List<String> ans, Trie root){
        if(row < 0 || col < 0 || row >= n || col >= m || board[row][col] == '!'){
            return;
        }
        char tmp = board[row][col];
        if(root.node[tmp - 'a'] == null){
            return;
        }
        root = root.node[tmp - 'a'];
        if(root.word != null && root.isEnd){
            ans.add(root.word);
            root.word = null;
        }
        board[row][col] = '!';
        track(board, row - 1, col, n, m, ans, root);
        track(board, row + 1, col, n, m, ans, root);
        track(board, row, col - 1, n, m, ans, root);
        track(board, row, col + 1, n, m, ans, root);
        board[row][col] = tmp;
    }
}
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;
        int len = words.length;
        List<String> ans = new ArrayList<>();
        Trie root = new Trie();
        for(int i = 0 ; i < len ; i++){
           root.insert(words[i], root);
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                root.track(board, i, j, n, m, ans, root);
            }
        }
        return ans;
    }
}