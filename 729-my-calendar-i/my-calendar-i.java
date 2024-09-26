class MyCalendar {
    List<List<Integer>> list;
    public MyCalendar() {
        list = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        int n = list.size();
        for(int i = 0 ; i < n ; i++){
            if(list.get(i).get(0) < end && list.get(i).get(1) > start){
                return false;
            }
        }
        List<Integer> tmp = new ArrayList<>();
        tmp.add(start);
        tmp.add(end);
        list.add(tmp);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */