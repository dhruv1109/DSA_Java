class Solution {
    class pair{
        int row;
        int col;
        pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }

    private void bfs(char[][] grid, int[][] vis, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        Queue<pair> q= new LinkedList<>();
        q.add(new pair(i,j));
        vis[i][j]=1;
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        while(!q.isEmpty()){
            pair p = q.poll();
            for(int d=0;d<4;d++){
                int x=p.row+dx[d];
                int y=p.col+dy[d];
                if(x>=0 && x<m && y>=0 && y<n && vis[x][y]!=1 && grid[x][y]=='1'){
                    q.add(new pair(x,y));
                    vis[x][y]=1;
                }
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
                    bfs(grid,vis,i,j);
                }
            }
        }
        return ans;
    }
}