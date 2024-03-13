class Solution {
    public int pivotInteger(int n) {
        int sum = n * (n + 1) / 2;
        int leftsum = 0;
        for(int i = 1 ; i <= n ; i++){
            if(leftsum == sum - leftsum - i){
                return i;
            }
            leftsum += i;
        }
        return -1;
    }
}