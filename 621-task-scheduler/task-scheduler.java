class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int len = tasks.length;
        for(int i = 0 ; i < len ; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.addAll(map.values());
        int ans = 0;
        while(!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            while(!queue.isEmpty()){
                temp.add(queue.poll());
            }
            for(int i : temp){
                i--;
                if(i > 0){
                    queue.add(i);
                }
            }
            ans += queue.isEmpty() ? temp.size() : n + 1;
        }
        return Math.max(len, ans);
    }
}
