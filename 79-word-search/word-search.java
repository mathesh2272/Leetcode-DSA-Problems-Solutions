class Solution {
    public boolean track(char[][] board, int row, int col, int ind, char[] word, int n, int m, int len){
        if(ind == len){
            return true;
        }
        if(row < 0 || col < 0 || row == n || col == m || board[row][col] == '2' || board[row][col] != word[ind]){
            return false;
        }
        char c = board[row][col];
        board[row][col] = '2';
        boolean flag = track(board, row + 1, col, ind + 1, word, n, m, len) || track(board, row - 1, col, ind + 1, word, n, m, len) || track(board, row, col - 1, ind + 1, word, n, m, len) || track(board, row, col + 1, ind + 1, word, n, m, len);
        board[row][col] = c;
        return flag;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        char[] ch = word.toCharArray();
        int len = ch.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(ch[0] == board[i][j] && track(board, i, j, 0, ch, n, m, len)){
                    return true;
                }
            }
        }
        return false;
    }
}