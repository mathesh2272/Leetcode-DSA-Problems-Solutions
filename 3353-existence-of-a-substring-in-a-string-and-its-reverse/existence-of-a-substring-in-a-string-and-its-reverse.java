class Solution {
    public boolean isSubstringPresent(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        int n = s.length();
        for(int i = 0 ; i < n - 1 ; i++){
            String substring = s.substring(i, i + 2);
            if(reverse.contains(substring)){
                return true;
            }
        }
        return false;
    }
}