class Solution {
    public void reverseString(char[] s) {
        char[] t = Arrays.copyOf(s, s.length);
        int n = t.length;
        for(int i = 0 ; i < n ; i++)
            s[i] = t[n - 1 - i];
    }
}