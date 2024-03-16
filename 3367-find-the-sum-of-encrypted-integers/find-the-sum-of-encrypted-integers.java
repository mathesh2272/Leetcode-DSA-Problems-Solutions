class Solution {
    public int maxDigit(int n) {
        int max = 0;
        while(n > 0){
            max = Math.max(max, n % 10);
            n /= 10;
        }
        return max;
    }
    public int encrypt(int n) {
        int max = maxDigit(n);
        int result = 0;
        int multiplier = 1;
        while(n > 0){
            result += max * multiplier;
            multiplier *= 10;
            n /= 10;
        }
        return result;
    }
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += encrypt(num);
        }
        return sum;
    }
}