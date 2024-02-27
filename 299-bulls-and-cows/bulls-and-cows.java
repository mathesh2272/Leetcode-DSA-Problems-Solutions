class Solution {
    public String getHint(String secret, String guess) {
        char[] secret_number = secret.toCharArray();
        char[] guess_number = guess.toCharArray();
        int n = secret_number.length;
        int[] secret_hash = new int[10];
        int[] guess_hash = new int[10];
        int bulls = 0;
        int cows = 0;
        for(int i = 0 ; i < n ; i++){
            if(secret_number[i] == guess_number[i]){
                bulls++;
            }
            else{
                secret_hash[secret_number[i] - '0']++;
                guess_hash[guess_number[i] - '0']++;
            }
        }
        for(int i = 0 ; i < 10 ; i++){
            if(guess_hash[i] != 0 && secret_hash[i] != 0){
                cows += Math.min(guess_hash[i], secret_hash[i]);
            } 
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bulls);
        sb.append("A");
        sb.append(cows);
        sb.append("B");
        return new String(sb);
    }
}