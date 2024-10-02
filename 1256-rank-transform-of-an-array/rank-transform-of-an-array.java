class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int[] array = arr.clone();
        Arrays.sort(arr);
        int i = 0;
        int rank = 1;
        Map<Integer, Integer> map = new HashMap<>();
        while(i < n){
            int val = arr[i];
            if(i < n && val == arr[i]){
                while(i < n && val == arr[i]){
                    map.put(arr[i], rank);
                    i++;
                }
            }
            else{
                i++;
            }
            rank++;
        }
        for(int j = 0 ; j < n ; j++){
            ans[j] = map.get(array[j]);
        }
        return ans;
    }
}