class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int n = fronts.length;
        Set<Integer> seen = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            if(fronts[i] == backs[i]){
                seen.add(fronts[i]);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            if(!seen.contains(fronts[i])){
                min = Math.min(min, fronts[i]);
            }
            if(!seen.contains(backs[i])){
                min = Math.min(min, backs[i]);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}