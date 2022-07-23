class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int count = count(board, i, j);
                if (count<2 && board[i][j]==1) board[i][j] = 2;
                else if (count>3 && board[i][j]==1) board[i][j] = 2;
                else if (count==3 && board[i][j]==0) board[i][j] = 3;
            }
        }
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j]==2) board[i][j] = 0;
                else if (board[i][j]==3) board[i][j] = 1;
            }
        }
    }
    public int count(int[][] board, int x, int y) {
        int count = 0;
        for (int i=x-1; i<=x+1; i++) {
            for (int j=y-1; j<=y+1; j++) {
                if (i==x && j==y) continue;
                if (i>=0 && i<board.length && j>=0 && j<board[0].length)
                    if (board[i][j]==1 || board[i][j]==2) count++;
            }
        }
        return count;
    }
}