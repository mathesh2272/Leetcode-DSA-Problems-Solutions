class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int durations = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for(int[] arr : courses){
            durations += arr[0];
            queue.offer(arr[0]);
            if(durations > arr[1]){
                durations -= queue.poll();
            }
        }
        return queue.size();
    }
}