class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        if (m>2 && n>2) {
            for (int i=0; i<m; i++) {
                if (board[i][0]=='O') flip(board,i,0);
                if (board[i][n-1]=='O') flip(board,i,n-1);
            }
            for (int i=0; i<n; i++) {
                if (board[0][i]=='O') flip(board,0,i);
                if (board[m-1][i]=='O') flip(board,m-1,i);
            }
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (board[i][j]=='O') board[i][j] = 'X';
                    else if (board[i][j]=='N') board[i][j] = 'O';
                }
            }
        }
    }
    public void flip(char[][] board, int i, int j) {
        if (i<0 || i>board.length-1 || j<0 || j>board[0].length-1) return;
        if (board[i][j]=='O') board[i][j] = 'N';
        if (i>0 && board[i-1][j]=='O') flip(board, i-1, j);
        if (i<board.length-1 && board[i+1][j]=='O') flip(board, i+1, j);
        if (j>0 && board[i][j-1]=='O') flip(board, i, j-1);
        if (j<board[0].length-1 && board[i][j+1]=='O') flip(board, i, j+1);
    }
}