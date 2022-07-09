class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0], c = click[1];
        if (board[r][c]=='M') board[r][c] = 'X';
        else reveal(board, r, c);
        return board;
    }
    public void reveal(char[][] board, int r, int c) {
        int count = 0;
        for (int i=r-1; i<=r+1; i++) {
            for (int j=c-1; j<=c+1; j++) {
                if (i==r && j==c) continue;
                if (i<0 || i==board.length || j<0 || j==board[0].length) continue;
                if (board[i][j]=='M') count++;
            }
        }
        if (count==0) { 
            board[r][c] = 'B';
            for (int i=r-1; i<=r+1; i++) {
                for (int j=c-1; j<=c+1; j++) {
                    if (i==r && j==c) continue;
                    if (i<0 || i==board.length || j<0 || j==board[0].length) continue;
                    if (board[i][j]=='E') reveal(board, i, j);
                }
            }
        }
        else board[r][c] = (char)(count+'0');
    }
}