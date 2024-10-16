class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        if(a > 0){
            pq.add(new int[]{'a', a});
        }
        if(b > 0){
            pq.add(new int[]{'b', b});
        }
        if(c > 0){
            pq.add(new int[]{'c', c});
        }
        while(!pq.isEmpty()){
            int[] poll = pq.poll();
            char ch = (char)poll[0];
            int n = sb.length();
            if(n > 1 && sb.charAt(n - 1) == sb.charAt(n - 2) && sb.charAt(n - 1) == ch){
                if(pq.isEmpty()){
                    break;
                }
                int[] nxt_poll = pq.poll();
                sb.append((char)nxt_poll[0]);
                nxt_poll[1] = nxt_poll[1] - 1;
                if(nxt_poll[1] > 0){
                    pq.add(nxt_poll);
                }
            }
            else{
                sb.append(ch);
                poll[1] = poll[1] - 1;
            }
            if(poll[1] > 0){
                pq.add(poll);
            }
        }
        return sb.toString();
    }
}