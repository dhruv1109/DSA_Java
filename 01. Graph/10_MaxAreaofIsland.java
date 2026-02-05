// https://leetcode.com/problems/max-area-of-island/description/

class Solution {
    private int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

    private int dfs(int[][] grid, int m, int n, int i, int j){
        int count = 1;
        grid[i][j] = 0;
        for(int [] d : dir){
            int x = i + d[0];
            int y = j + d[1];
            if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1)
                count +=dfs(grid,m,n,x,y);
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int count = dfs(grid,m,n,i,j);
                    ans = Math.max(ans,count);
                }
            }
        }
        return ans;
    }
}