class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] arr = sentence.split(" ");
        int n = arr.length;
        for(int i = 0 ; i < n ; i++){
            String str = "";
            int min = Integer.MAX_VALUE;
            for(String s : dictionary){
                if(arr[i].startsWith(s)){
                    int len = s.length();
                    if(min > len){
                        min = len;
                        str = s;
                    }
                }
            }
            if(min != Integer.MAX_VALUE){
                sb.append(str);
            }
            else{
                sb.append(arr[i]);
            }
            if(i != n-1){
                sb.append(" ");
            }
        }
        return new String(sb);
    }
}