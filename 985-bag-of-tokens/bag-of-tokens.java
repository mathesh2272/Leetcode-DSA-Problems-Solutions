class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length - 1;
        int ans = 0;
        int max = 0;
        while(left <= right){
            if(power >= tokens[left]){
                power -= tokens[left++];
                ans++;
                max = Math.max(max, ans);
            }
            else if(ans > 0){
                power += tokens[right--];
                ans--;
            }
            else{
                break;
            }
        }
        return max;
    }
}