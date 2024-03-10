class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int inc = 0;
        int n = happiness.length;
        Arrays.sort(happiness);
        long sum = 0;
        for(int i = n - 1 ; i >= 0 && k > 0 ; i--, k--){
            sum += Math.max(0, happiness[i] - inc);
            inc++;
        }
        return sum;
    }
}