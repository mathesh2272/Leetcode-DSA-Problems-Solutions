class Solution {
    int union[];
    public int findParentInd(int ind){
        if(ind == union[ind]){
            return ind;
        }
        return union[ind] = findParentInd(union[ind]);
    }
    public void unionSet(int a, int b){
        int parent_a = findParentInd(a);
        int parent_b = findParentInd(b);
        if(parent_a < parent_b){
            union[parent_b] = parent_a;
        }
        else{
            union[parent_a] = parent_b;
        }
    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        union = new int[n];
        for(int i = 0 ; i < n ; i++){
            union[i] = i;
        }
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        unionSet(0, firstPerson);
        int len = meetings.length;
        int ind = 0;
        while(ind < len){
            Set<Integer> set = new HashSet<>();
            int curr_time = meetings[ind][2];
            while(ind < len && curr_time == meetings[ind][2]){
                int min = Math.min(meetings[ind][0], meetings[ind][1]);
                int max = Math.max(meetings[ind][0], meetings[ind][1]);
                unionSet(min, max);
                set.add(meetings[ind][0]);
                set.add(meetings[ind][1]);
                ind++;
            }
            for(int ele : set){
                if(findParentInd(ele) != 0){
                    union[ele] = ele;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(findParentInd(i) == 0){
                list.add(i);
            }
        }
        return list;
    }
}