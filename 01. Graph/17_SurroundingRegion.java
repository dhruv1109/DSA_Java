// https://leetcode.com/problems/surrounded-regions/

class Solution {
    private void dfs(int i,int j,boolean[][] vis,char[][] board,int m,int n){
        vis[i][j]= true;
        int[] dx = {1,0,0,-1};
        int[] dy = {0,1,-1,0};
        for(int d=0;d<4;d++){
            int x = i + dx[d];
            int y = j + dy[d];
            if(x>=0 && y>=0 && x<m && y<n && board[x][y]=='O' && !vis[x][y])
                dfs(x,y,vis,board,m,n);
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];

        for(int i=0;i<m;i++){
            if(board[i][0]=='O' && !vis[i][0]){
                dfs(i,0,vis,board,m,n);
            }
            if(board[i][n-1]=='O' && !vis[i][n-1]){
                dfs(i,n-1,vis,board,m,n);
            }
        }

        for(int j=0;j<n;j++){
            if(board[0][j]=='O' && !vis[0][j]){
                dfs(0,j,vis,board,m,n);
            }
            if(board[m-1][j]=='O' && !vis[m-1][j]){
                dfs(m-1,j,vis,board,m,n);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && !vis[i][j])
                    board[i][j] = 'X';
            }
        }
    }
}