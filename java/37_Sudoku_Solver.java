class Solution {
    public void solveSudoku(char[][] board) {
        recursion(board, 0, 0);
    }
    public boolean recursion(char[][] board, int x, int y) {
        if (y==9) return true;
        int X = (x+1) % 9, Y = (X==0) ? y+1 : y;
        if (board[x][y]!='.') return recursion(board, X, Y);
        for (char c='1'; c<='9'; c++) {
            if (check(board, x, y, c)) {
                board[x][y] = c;
                if (recursion(board, X, Y)) return true;
                board[x][y] = '.';
            }
        }
        return false;
    }
    public boolean check(char[][] board, int x, int y, char c) {
        for(int i=0; i<9; i++)
            if(board[x][i]==c || board[i][y]==c || board[x/3*3+i/3][y/3*3+i%3]==c)
                return false;
        return true;
    }
}