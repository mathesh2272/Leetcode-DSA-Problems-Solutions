class Solution {
    public long dividePlayers(int[] skills) {
        Arrays.sort(skills);
        int n = skills.length;
        long ans = 0;
        int sum = skills[0] + skills[n - 1];
        for(int i = 0 ; i < n / 2 ; i++){
            if(skills[i] + skills[n - i - 1] != sum){
                return -1;
            }
            ans = ans + (skills[i] * skills[n - i - 1]);
        }
        return ans;
    }
}