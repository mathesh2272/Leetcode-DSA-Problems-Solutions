class Solution {
    public int[] getZAlgo(char[] ch){
        int n = ch.length;
        int left = 0;
        int right = 0;
        int[] zAlgo = new int[n];
        for(int i = 1 ; i < n ; i++){
            if(i > right){
                left = right = i;
                while(right < n && ch[right] == ch[right - left]){
                    right++;
                }
                zAlgo[i] = right - left;
                right--;
            }
            else{
                if(zAlgo[i - left] < right - i + 1){
                    zAlgo[i] = zAlgo[i - left];
                }
                else{
                    left = i;
                    while(right < n && ch[right] == ch[right - left]){
                        right++;
                    }
                    zAlgo[i] = right - left;
                    right--;
                }
            }
        }
        return zAlgo;
    }
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append("2");
        sb.append(s);
        int[] zAlgo1 = getZAlgo(sb.toString().toCharArray());
        sb = new StringBuilder();
        sb.append(b);
        sb.append("2");
        sb.append(s);
        int[] zAlgo2 = getZAlgo(sb.toString().toCharArray());
        int n = zAlgo1.length;
        int a_len = a.length();
        List<Integer> list1 = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(zAlgo1[i] == a_len){
                list1.add(i - a_len - 1);
            }
        }
        int b_len = b.length();
        n = zAlgo2.length;
        List<Integer> list2 = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(zAlgo2[i] == b_len){
                list2.add(i - b_len - 1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int ele1 : list1){
            for(int ele2 : list2){
                if(Math.abs(ele1 - ele2) <= k){
                    ans.add(ele1);
                    break;
                }
            }
        }
        return ans;
    }
}