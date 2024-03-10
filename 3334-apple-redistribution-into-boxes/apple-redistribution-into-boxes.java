class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples = 0;
        for(int apples : apple){
            totalApples += apples;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int cap : capacity){
            maxHeap.add(cap);
        }
        int boxCount = 0;
        while(totalApples > 0){
            totalApples -= maxHeap.poll();
            boxCount++;
        }
        return boxCount;
    }
}