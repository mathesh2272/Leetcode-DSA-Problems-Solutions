class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.length() > sentence2.length()){
            String tmp = sentence1;
            sentence1 = sentence2;
            sentence2 = tmp;
        }
        String[] arr_1 = sentence1.split(" ");
        String[] arr_2 = sentence2.split(" ");
        int i = 0;
        int j = 0;
        int n = arr_1.length;
        int m = arr_2.length;
        while(i < n && j < m && arr_1[i].equals(arr_2[j])){
            i++;
            j++;
        }
        int x = n - 1;
        int y = m - 1;
        while(x >= 0 && y >= 0 && arr_1[x].equals(arr_2[y])){
            x--;
            y--;
        }
        return x < i;
    }
}