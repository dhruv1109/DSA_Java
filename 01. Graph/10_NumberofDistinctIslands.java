// https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1

class Solution {
    
    int[] dx = {1,0,0,-1};
    int[] dy = {0,1,-1,0};
    
    private void dfs(int r, int c, int[][] grid, int[][] vis, 
    StringBuilder sb, int r0,int c0, int m, int n){
        vis[r][c]=1;
        sb.append(r - r0).append(c - c0);

        for(int d=0;d<4;d++){
            int newr = r + dx[d];
            int newc = c + dy[d];
            if(newr >=0 && newr<m && newc>=0 && newc<n &&
            grid[newr][newc]==1 && vis[newr][newc]==0){
                dfs(newr,newc,grid,vis,sb,r0,c0,m,n);
            }
        }
    }

    int countDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        HashSet<String> s = new HashSet<>();
        int[][] vis = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    StringBuilder sb = new StringBuilder();
                    dfs(i,j,grid,vis,sb,i,j,m,n);
                    s.add(sb.toString());
                }
            }
        }
        return s.size();
    }
}
