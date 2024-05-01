class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        String em = word.substring(0, index + 1);
        StringBuilder sb = new StringBuilder(em);
        sb.reverse();
        return new String(sb) + word.substring(index + 1, word.length());
    }
}