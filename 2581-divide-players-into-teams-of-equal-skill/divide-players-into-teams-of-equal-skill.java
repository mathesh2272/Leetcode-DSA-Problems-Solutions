class Solution {
    public long dividePlayers(int[] skills) {
        Arrays.sort(skills);
        int n = skills.length;
        long ans = 0;
        for(int i = 0 ; i < n / 2 ; i++){
            if(i + 1 < n && n - i - 2 >= 0 && skills[i] + skills[n - i - 1] != skills[i + 1] + skills[n - i - 2]){
                return -1;
            }
            ans = ans + (skills[i] * skills[n - i - 1]);
        }
        return ans;
    }
}