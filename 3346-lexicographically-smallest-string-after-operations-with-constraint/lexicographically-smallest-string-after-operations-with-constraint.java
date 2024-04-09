class Solution {
    public String getSmallestString(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        for(int i = 0 ; i < n && k > 0 ; i++){
            if(ch[i] == 'a'){
                continue;
            }
            // front
            char tmp1 = ch[i];
            int t1 = k;
            int f = 0;
            while(tmp1 != 'a'){
                tmp1++;
                f++;
                t1--;
                if(tmp1 > 'z'){
                    tmp1 = 'a';
                }
                if(t1 == 0){
                    break;
                }
            }
            // back
            char tmp2 = ch[i];
            int t2 = k;
            int d = 0;
            while(tmp2 != 'a'){
                tmp2--;
                d++;
                t2--;
                if(t2 == 0){
                    break;
                }
            }
            if(k - Math.min(f, d) > 0){
                ch[i] = 'a';
                k -= Math.min(f, d);
            }
            else{
                if(tmp1 > tmp2){
                    ch[i] = tmp2;
                }
                else{
                    ch[i] = tmp1;
                }
                break;
            }
        }
        return new String(ch);
    }
}