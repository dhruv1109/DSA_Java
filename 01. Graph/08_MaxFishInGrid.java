// https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/description/

class Solution {
    private int dfs(int[][] grid, int i, int j, int m, int n){
        int count = grid[i][j];
        grid[i][j] = -1;
        int[] dx = {1,0,0,-1};
        int[] dy = {0,1,-1,0};
        for(int d=0;d<4;d++){
            int x = i + dx[d];
            int y = j + dy[d];
            if(x>=0 && y>=0 && x<m && y<n && grid[x][y]>0)
                count += dfs(grid,x,y,m,n);
        }
        return count;
    }
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0){
                    int count = dfs(grid,i,j,m,n);
                    ans = Math.max(ans,count);
                }
            }
        }
        return ans;
    }
}