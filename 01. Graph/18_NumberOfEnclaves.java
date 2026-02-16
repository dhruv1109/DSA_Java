// https://leetcode.com/problems/number-of-enclaves/description/

class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    private void bfs(int i, int j,int[][] vis, int[][] grid, int m,int n){
        vis[i][j]=1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        int[] dx = {1,0,0,-1};
        int[] dy = {0,-1,1,0};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.row;
            int y = p.col;
            for(int d=0;d<4;d++){
                int newx = x + dx[d];
                int newy = y + dy[d];
                if(newx>=0 && newy>=0 && newx<m && newy<n && 
                vis[newx][newy]==0 && grid[newx][newy]==1){
                    vis[newx][newy] = 1;
                    q.add(new Pair(newx,newy));
                }
            }
        }

    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];

        for(int i =0; i<m;i++){
            if(grid[i][0]==1 && vis[i][0]==0)
                bfs(i,0,vis,grid,m,n);

            if(grid[i][n-1]==1 && vis[i][n-1]==0)
                bfs(i,n-1,vis,grid,m,n);
        }

        for(int j=0;j<n;j++){
            if(grid[0][j]==1 && vis[0][j]==0)
                bfs(0,j,vis,grid,m,n);

            if(grid[m-1][j]==1 && vis[m-1][j]==0)
                bfs(m-1,j,vis,grid,m,n);
        }

        int count =0;
        for(int i =0; i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==0)
                    count++;
            }
        }

        return count;
    }
}