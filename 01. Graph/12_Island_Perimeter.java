// https://leetcode.com/problems/island-perimeter/description/

class Solution {
    int m,n,param=0;
    private void dfs(int[][] grid, int i,int j){
        if(i>=m || j>=n || i<0 || j<0 || grid[i][j]==0)
        {
            param++;
            return;
        }
        if(grid[i][j]==-1)
            return;
        
        grid[i][j]=-1;
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
    public int islandPerimeter(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    dfs(grid,i,j);
            }
        }
        return param;
    }
}