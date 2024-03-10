public class Solution {
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String[] answer = new String[n];
        Arrays.fill(answer, "");
        for(int i = 0 ; i < n ; i++){
            int len1 = arr[i].length();
            for(int len = 1 ; len <= len1 ; len++){
                String minSubstring = "";
                for(int start = 0; start + len <= len1 ; start++){
                    String substring = arr[i].substring(start, start + len);
                    boolean found = false;
                    for(int j = 0; j < n ; j++) {
                        if(j != i && arr[j].contains(substring)){
                            found = true;
                            break;
                        }
                    }
                    if(!found && (minSubstring.equals("") || substring.compareTo(minSubstring) < 0)){
                        minSubstring = substring;
                    }
                }
                if(!minSubstring.equals("")){
                    answer[i] = minSubstring;
                    break;
                }
            }
        }
        return answer;
    }
}
