class Solution {
    public boolean check(int val1, int val2, int[] arr, int n){
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] >= val2 && arr[mid] <= val1){
                return true;
            }
            else if(arr[mid] > val1){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return false;
    }
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
        int[] index_first = new int[s.length()];
        int n1 = 0;
        for(int i = 0 ; i < n ; i++){
            if(zAlgo1[i] == a_len){
                index_first[n1++] = i - a_len - 1;
            }
        }
        int b_len = b.length();
        n = zAlgo2.length;
        int[] index_second = new int[s.length()];
        int n2 = 0;
        List<Integer> list2 = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(zAlgo2[i] == b_len){
                index_second[n2++] = i - b_len - 1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < n1 ; i++){
            if(check(index_first[i] + k, index_first[i] - k, index_second, n2)){
                ans.add(index_first[i]);
            }
        }
        return ans;
    }
}