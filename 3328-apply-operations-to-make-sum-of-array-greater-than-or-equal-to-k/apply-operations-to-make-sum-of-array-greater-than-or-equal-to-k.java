class Solution {
    public int minOperations(int k) {
        if(k == 1){
            return 0;
        }
        int num = 1;
        int min = Integer.MAX_VALUE;
        while(num <= k){
            int val = num - 1;
            val += (k % num == 0 ? (k / num) - 1 : k / num);
            min = Math.min(min, val);
            num++;
        }
        return min;
    }
}