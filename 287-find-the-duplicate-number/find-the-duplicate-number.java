class Solution {
    public int findDuplicate(int[] nums) {
        int[] fre = new int[nums.length + 1];
        for(int ele : nums){
            fre[ele]++;
            if(fre[ele] == 2){
                return ele;  
            } 
        }
        return 0;
    }
}