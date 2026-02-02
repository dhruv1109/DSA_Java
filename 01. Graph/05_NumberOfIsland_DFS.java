class Solution {

    private void dfs(char[][] grid, int[][] vis, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        vis[i][j]=1;
        int[] dx={1,0,0,-1};
        int[] dy={0,1,-1,0};
        for(int d=0;d<4;d++){
            int x=i+dx[d];
            int y=j+dy[d];
            if(x>=0 && x<m && y>=0 && y<n && grid[x][y]=='1' && vis[x][y]!=1){
                dfs(grid,vis,x,y);
            }

        }
    }
    
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && vis[i][j]!=1)
                {
                    ans++;
                    dfs(grid,vis,i,j);
                }
            }
        }
        return ans;
    }
}