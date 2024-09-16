class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[][] prefix = new int[n][26];
        prefix[0][ch[0] - 'a']++;
        for(int i = 1 ; i < n ; i++){
            int[] tmp = prefix[i - 1].clone();
            prefix[i] = tmp;
            prefix[i][ch[i] - 'a']++;
        }
        // for(int[] i : prefix) System.out.println(Arrays.toString(i));
        List<Boolean> ans = new ArrayList<>();
        for(int[] query : queries){
            int left = query[0];
            int right = query[1];
            int k = query[2];
            int cnt = 0;
            if(left == 0){
                for(int i = 0 ; i < 26 ; i++){
                    cnt = cnt + (prefix[right][i] % 2);
                }
            }
            else{
                for(int i = 0 ; i < 26 ; i++){
                    cnt = cnt + (prefix[right][i] - prefix[left - 1][i]) % 2;
                }
            }
            // System.out.println(cnt);
            ans.add(cnt / 2 <= k);
        }
        return ans;
    }
}