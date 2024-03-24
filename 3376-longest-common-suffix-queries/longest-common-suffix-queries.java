class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int index = -1;
        int minLen = Integer.MAX_VALUE;
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode root = new TrieNode();
        int maxlen = Integer.MAX_VALUE;
        int ind = 0;
        int len = wordsContainer.length;
        for(int i = 0 ; i < len ; i++) {
            String word = new StringBuilder(wordsContainer[i]).reverse().toString();
            TrieNode node = root;
            int n = word.length();
            if(maxlen > n){
                maxlen = n;
                ind = i;
            }
            for(char c : word.toCharArray()){
                if(node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
                if(node.minLen > n) {
                    node.minLen = n;
                    node.index = i;
                }
            }
        }
        int m = wordsQuery.length;
        int[] ans = new int[m];
        for(int i = 0; i < m; i++) {
            String word = new StringBuilder(wordsQuery[i]).reverse().toString();
            TrieNode node = root;
            for(char c : word.toCharArray()) {
                if(node.children[c - 'a'] == null) {
                    break;
                }
                node = node.children[c - 'a'];
            }
            ans[i] = node.index == -1 ? ind : node.index;
        }
        return ans;
    }
}
