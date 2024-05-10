class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> queue = new PriorityQueue<>(Comparator.comparingDouble(a -> a[0]));
        int n = arr.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                queue.add(new double[]{(double)arr[i] / arr[j], arr[i], arr[j]});
            }
        }
        while(k-- > 1){
            queue.poll();
        }
        double[] poll = queue.poll();
        return new int[]{(int)poll[1], (int)poll[2]};
    }
}