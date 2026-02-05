//  https://leetcode.com/problems/coloring-a-border/description/

class Solution {
    private void dfs(int[][] grid, int i, int j, int curr,int m,int n){
        grid[i][j]=-1;
        int[] dx = {1,0,0,-1};
        int[] dy = {0,-1,1,0};
        for(int d=0;d<4;d++){
            int x= i + dx[d];
            int y= j + dy[d];
            if(x>=0 && y>=0 && x<m && y<n && grid[x][y]==curr)
                dfs(grid,x,y,curr,m,n);
        }
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int curr = grid[row][col];
        int m = grid.length;
        int n= grid[0].length;
        dfs(grid,row,col,curr,m,n);
        boolean[][] isBorder = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) {
                    if (i == 0 || j == 0 || i == m - 1 || j == n - 1
                        || grid[i - 1][j] != -1
                        || grid[i + 1][j] != -1
                        || grid[i][j - 1] != -1
                        || grid[i][j + 1] != -1) {
                        isBorder[i][j] = true;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) {
                    grid[i][j] = isBorder[i][j] ? color : curr;
                }
            }
        }
        return grid;
    }
}