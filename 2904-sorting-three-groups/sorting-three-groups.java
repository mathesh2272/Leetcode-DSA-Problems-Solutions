class Solution {
    public int minimumOperations(List<Integer> arr) {
        int n = arr.size();
        int[] nums = new int[n];
        int ind = 0;
        for(int ele : arr){
            nums[ind++] = ele;
        }
        int min = n;
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= n ; j++){
                int cnt = 0;
                for(int k = 0 ; k < n ; k++){
                    if(k < i){
                        if(nums[k] != 1){
                            cnt++;
                        }
                    }
                    else if(k < j){
                        if(nums[k] != 2){
                            cnt++;
                        }
                    }
                    else if(nums[k] != 3){
                        cnt++;
                    }
                }
                min = Math.min(min, cnt);
            }
        }
        return min;
    }
}