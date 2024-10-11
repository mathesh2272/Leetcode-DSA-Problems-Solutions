class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int[][] time = new int[n][3];
        PriorityQueue<Integer> chair = new PriorityQueue<>();
        for(int i = 0 ; i < n ; i++){
            time[i][0] = times[i][0];
            time[i][1] = times[i][1];
            time[i][2] = i;
            chair.add(i);
        }
        Arrays.sort(time, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int[] arr : time){
            int start = arr[0];
            int end = arr[1];
            int ch = arr[2];
            while(!pq.isEmpty() && pq.peek()[0] <= start){
               chair.add(pq.poll()[1]);
            }
            int val = chair.poll();
            if(ch == targetFriend){
                return val;
            }
            pq.add(new int[]{end, val});
        }
        return 0;
    }
}