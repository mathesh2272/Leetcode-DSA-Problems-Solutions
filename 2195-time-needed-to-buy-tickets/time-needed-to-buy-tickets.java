class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int sec = 0;
        int n = tickets.length;
        while(tickets[k] != 0){
            for(int i = 0 ; i < n ; i++){
                if(tickets[i] > 0) {
                    tickets[i]--;
                    sec++;
                }
                if(tickets[k] == 0)
                    break;
            }
        }
        return sec;
    }
}