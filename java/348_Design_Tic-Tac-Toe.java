class TicTacToe {
    private int[] r;
    private int[] c;
    private int d1;
    private int d2;
    private int n;
    public TicTacToe(int n) {
        r = new int[n];
        c = new int[n];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        int p = (player==1) ? 1 : -1;
        r[row] += p;
        c[col] += p;
        if (row==col) d1 += p;
        if (row+col==n-1) d2 += p;
        if (Math.abs(r[row])==n || Math.abs(c[col])==n || Math.abs(d1)==n || Math.abs(d2)==n)
            return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */