// https://leetcode.com/problems/minesweeper/description/

class Solution {
    private int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0];
        int j = click[1];
        int m = board.length;
        int n = board[0].length;

        if(board[i][j]=='M')
        {
            board[i][j]='X';
            return board;
        }
        int mine = 0;
        for(int[] d:dir){
            int x=i+d[0];
            int y=j+d[1];
            if(x>=0 && x<m && y>=0 && y<n && board[x][y]=='M'){
                mine++;
            }
        }
        if(mine>0)
        {
            board[i][j]=(char)(mine + '0');
            return board;
        }
        board[i][j]='B';
        for(int[] d:dir){
            int x=i+d[0];
            int y=j+d[1];
            if(x>=0 && x<m && y>=0 && y<n && board[x][y]=='E'){
                updateBoard(board, new int[]{x,y});
            }
        }
        return board;
    }
}