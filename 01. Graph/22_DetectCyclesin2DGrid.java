// https://leetcode.com/problems/detect-cycles-in-2d-grid/description/

class Solution {
    int[] dx = {1,0,0,-1};
    int[] dy = {0,1,-1,0};

    private boolean dfs(int i, int j,int[][] vis,char[][] grid, int pi, int pj, int m,int n){
        vis[i][j]=1;
        for(int d=0;d<4;d++){
            int x= i + dx[d];
            int y= j + dy[d];  
            if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==grid[i][j]){
                if(vis[x][y]==0){
                    if(dfs(x,y,vis,grid,i,j,m,n)==true)
                        return true;
                } else if(x!=pi || y!=pj)
                    return true;
            }
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0){
                    if(dfs(i,j,vis,grid,i,j,m,n)==true)
                        return true;
                }
            }
        }
        return false;
    }
}