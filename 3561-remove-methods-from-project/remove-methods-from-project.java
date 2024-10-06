class Solution {
    public void dfs(List<Integer>[] list, int k, Set<Integer> suspicious){
        suspicious.add(k);
        for(int val : list[k]){
            if(!suspicious.contains(val)){
                dfs(list, val, suspicious);
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] list = new ArrayList[n];
        List<Integer> another = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            list[i] = new ArrayList<>();
            another.add(i);
        }
        for(int[] arr : invocations){
            list[arr[0]].add(arr[1]);
        }
        Set<Integer> suspicious = new HashSet<>();
        dfs(list, k, suspicious);
        for(int i = 0 ; i < n ; i++){
            if(suspicious.contains(i)){
                continue;
            }
            for(int ele : list[i]){
                if(suspicious.contains(ele)){
                    return another;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(!suspicious.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}