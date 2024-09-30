class CustomStack {
    int[] stack;
    int i;
    int n;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        i = 0;
        n = maxSize;
    }
    
    public void push(int x) {
        if(i < n){
            stack[i++] = x;
        }
    }
    
    public int pop() {
        if(i == 0){
            return -1;
        }
        i--;
        return stack[i];
    }
    
    public void increment(int k, int val) {
        int j = 0;
        while(k-- > 0 && j < i){
            stack[j] = stack[j] + val;
            j++;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */